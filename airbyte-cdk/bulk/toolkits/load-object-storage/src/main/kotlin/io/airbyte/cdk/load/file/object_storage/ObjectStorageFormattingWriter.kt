/*
 * Copyright (c) 2024 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.cdk.load.file.object_storage

import io.airbyte.cdk.load.command.DestinationStream
import io.airbyte.cdk.load.command.object_storage.AvroFormatConfiguration
import io.airbyte.cdk.load.command.object_storage.CSVFormatConfiguration
import io.airbyte.cdk.load.command.object_storage.JsonFormatConfiguration
import io.airbyte.cdk.load.command.object_storage.ObjectStorageCompressionConfigurationProvider
import io.airbyte.cdk.load.command.object_storage.ObjectStorageFormatConfigurationProvider
import io.airbyte.cdk.load.command.object_storage.ParquetFormatConfiguration
import io.airbyte.cdk.load.config.DataChannelFormat
import io.airbyte.cdk.load.config.DataChannelMedium
import io.airbyte.cdk.load.data.ObjectType
import io.airbyte.cdk.load.data.avro.toAvroRecord
import io.airbyte.cdk.load.data.avro.toAvroSchema
import io.airbyte.cdk.load.data.csv.toCsvRecord
import io.airbyte.cdk.load.data.dataWithAirbyteMeta
import io.airbyte.cdk.load.data.withAirbyteMeta
import io.airbyte.cdk.load.file.StreamProcessor
import io.airbyte.cdk.load.file.avro.toAvroWriter
import io.airbyte.cdk.load.file.csv.toCsvPrinterWithHeader
import io.airbyte.cdk.load.file.parquet.ParquetWriter
import io.airbyte.cdk.load.file.parquet.toParquetWriter
import io.airbyte.cdk.load.message.DestinationRecordRaw
import io.airbyte.cdk.load.util.serializeToString
import io.airbyte.cdk.load.util.write
import io.github.oshai.kotlinlogging.KotlinLogging
import io.micronaut.context.annotation.Secondary
import jakarta.inject.Named
import jakarta.inject.Singleton
import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.OutputStream
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.atomic.AtomicLong
import org.apache.avro.Schema

interface ObjectStorageFormattingWriter : Closeable {
    fun accept(record: DestinationRecordRaw)
    fun flush()
}

abstract class ManagedByteArrayOutputStream(initialCapacity: Int) :
    ByteArrayOutputStream(initialCapacity) {
    abstract fun extractBytes(): ByteArray
    abstract fun resetBuffer()
}

class StandardByteArrayOutputStream : ManagedByteArrayOutputStream(32) {
    override fun extractBytes(): ByteArray = toByteArray()
    override fun resetBuffer() = reset()
}

interface ObjectStorageFormattingWriterFactory {
    fun create(stream: DestinationStream, outputStream: OutputStream): ObjectStorageFormattingWriter
}

@Singleton
@Secondary
class DefaultObjectStorageFormattingWriterFactory(
    private val formatConfigProvider: ObjectStorageFormatConfigurationProvider,
    @Named("dataChannelFormat") private val dataChannelFormat: DataChannelFormat
) : ObjectStorageFormattingWriterFactory {
    override fun create(
        stream: DestinationStream,
        outputStream: OutputStream
    ): ObjectStorageFormattingWriter {
        val flatten = formatConfigProvider.objectStorageFormatConfiguration.rootLevelFlattening
        // TODO: FileWriter

        return when (formatConfigProvider.objectStorageFormatConfiguration) {
            is JsonFormatConfiguration ->
                if (dataChannelFormat == DataChannelFormat.PROTOBUF) {
                    ProtoToJsonFormatter(
                        stream = stream,
                        outputStream = outputStream,
                        rootLevelFlattening = flatten,
                    )
                } else {
                    JsonFormattingWriter(
                        stream = stream,
                        outputStream = outputStream,
                        rootLevelFlattening = flatten,
                    )
                }
            is AvroFormatConfiguration ->
                if (dataChannelFormat == DataChannelFormat.PROTOBUF) {
                    ProtoToAvroFormatter(
                        stream = stream,
                        outputStream = outputStream,
                        formatConfig =
                            formatConfigProvider.objectStorageFormatConfiguration
                                as AvroFormatConfiguration,
                        rootLevelFlattening = flatten,
                    )
                } else {
                    AvroFormattingWriter(
                        stream = stream,
                        outputStream = outputStream,
                        formatConfig =
                            formatConfigProvider.objectStorageFormatConfiguration
                                as AvroFormatConfiguration,
                        rootLevelFlattening = flatten,
                    )
                }
            is ParquetFormatConfiguration ->
                if (dataChannelFormat == DataChannelFormat.PROTOBUF) {
                    ProtoToParquetFormatter(
                        stream = stream,
                        outputStream = outputStream,
                        formatConfig =
                            formatConfigProvider.objectStorageFormatConfiguration
                                as ParquetFormatConfiguration,
                        rootLevelFlattening = flatten,
                    )
                } else {
                    ParquetFormattingWriter(
                        stream = stream,
                        outputStream = outputStream,
                        formatConfig =
                            formatConfigProvider.objectStorageFormatConfiguration
                                as ParquetFormatConfiguration,
                        rootLevelFlattening = flatten,
                    )
                }
            is CSVFormatConfiguration ->
                if (dataChannelFormat == DataChannelFormat.PROTOBUF) {
                    ProtoToCsvFormatter(
                        stream = stream,
                        outputStream = outputStream,
                        rootLevelFlattening = flatten,
                        extractedAtAsTimestampWithTimezone = false,
                    )
                } else {
                    CSVFormattingWriter(
                        stream = stream,
                        outputStream = outputStream,
                        rootLevelFlattening = flatten,
                        extractedAtAsTimestampWithTimezone = false,
                    )
                }
        }
    }
}

class JsonFormattingWriter(
    private val stream: DestinationStream,
    private val outputStream: OutputStream,
    private val rootLevelFlattening: Boolean,
) : ObjectStorageFormattingWriter {

    override fun accept(record: DestinationRecordRaw) {
        val data =
            record
                .asDestinationRecordAirbyteValue()
                .dataWithAirbyteMeta(
                    stream = stream,
                    flatten = rootLevelFlattening,
                    airbyteRawId = record.airbyteRawId,
                )
                .toJson()
                .serializeToString()
        outputStream.write(data)
        outputStream.write("\n")
    }

    override fun flush() {
        outputStream.flush()
    }

    override fun close() {
        outputStream.close()
    }
}

class CSVFormattingWriter(
    private val stream: DestinationStream,
    outputStream: OutputStream,
    private val rootLevelFlattening: Boolean,
    private val extractedAtAsTimestampWithTimezone: Boolean,
) : ObjectStorageFormattingWriter {

    private val finalSchema = stream.schema.withAirbyteMeta(rootLevelFlattening)
    private val printer = finalSchema.toCsvPrinterWithHeader(outputStream)
    override fun accept(record: DestinationRecordRaw) {
        printer.printRecord(
            record
                .asDestinationRecordAirbyteValue()
                .dataWithAirbyteMeta(
                    stream = stream,
                    flatten = rootLevelFlattening,
                    extractedAtAsTimestampWithTimezone = extractedAtAsTimestampWithTimezone,
                    airbyteRawId = record.airbyteRawId,
                )
                .toCsvRecord(finalSchema)
        )
    }

    override fun flush() {
        printer.flush()
    }

    override fun close() {
        printer.close()
    }
}

class AvroFormattingWriter(
    private val stream: DestinationStream,
    outputStream: OutputStream,
    formatConfig: AvroFormatConfiguration,
    private val rootLevelFlattening: Boolean,
) : ObjectStorageFormattingWriter {
    val log = KotlinLogging.logger {}

    @Suppress("DEPRECATION")
    private val pipeline = io.airbyte.cdk.load.data.avro.AvroMapperPipelineFactory().create(stream)
    private val mappedSchema = pipeline.finalSchema.withAirbyteMeta(rootLevelFlattening)
    private val avroSchema = mappedSchema.toAvroSchema(stream.mappedDescriptor)
    private val writer =
        outputStream.toAvroWriter(avroSchema, formatConfig.avroCompressionConfiguration)

    init {
        log.info { "Generated avro schema: $avroSchema" }
    }

    override fun accept(record: DestinationRecordRaw) {
        val marshalledRecord = record.asDestinationRecordAirbyteValue()
        val dataMapped = pipeline.map(marshalledRecord.data, marshalledRecord.meta?.changes)
        val withMeta =
            dataMapped.withAirbyteMeta(
                stream = stream,
                emittedAtMs = marshalledRecord.emittedAtMs,
                flatten = rootLevelFlattening,
                airbyteRawId = record.airbyteRawId,
            )
        writer.write(withMeta.toAvroRecord(mappedSchema, avroSchema))
    }

    override fun flush() {
        writer.flush()
    }

    override fun close() {
        writer.close()
    }
}

class ParquetFormattingWriter(
    private val stream: DestinationStream,
    outputStream: OutputStream,
    formatConfig: ParquetFormatConfiguration,
    private val rootLevelFlattening: Boolean,
) : ObjectStorageFormattingWriter {
    private val log = KotlinLogging.logger {}

    @Suppress("DEPRECATION")
    private val pipeline =
        io.airbyte.cdk.load.data.parquet.ParquetMapperPipelineTest().create(stream)
    private val mappedSchema: ObjectType = pipeline.finalSchema.withAirbyteMeta(rootLevelFlattening)
    private val avroSchema: Schema = mappedSchema.toAvroSchema(stream.mappedDescriptor)
    private val writer: ParquetWriter =
        outputStream.toParquetWriter(avroSchema, formatConfig.parquetWriterConfiguration)

    init {
        log.info { "Generated avro schema: $avroSchema" }
    }

    override fun accept(record: DestinationRecordRaw) {
        val marshalledRecord = record.asDestinationRecordAirbyteValue()
        val dataMapped = pipeline.map(marshalledRecord.data, marshalledRecord.meta?.changes)
        val withMeta =
            dataMapped.withAirbyteMeta(
                stream = stream,
                emittedAtMs = marshalledRecord.emittedAtMs,
                flatten = rootLevelFlattening,
                airbyteRawId = record.airbyteRawId,
            )
        writer.write(withMeta.toAvroRecord(mappedSchema, avroSchema))
    }

    override fun flush() {
        // Parquet writer does not support flushing
    }

    override fun close() {
        writer.close()
    }
}

@Singleton
@Secondary
class BufferedFormattingWriterFactory<T : OutputStream>(
    private val writerFactory: ObjectStorageFormattingWriterFactory,
    private val compressionConfigurationProvider: ObjectStorageCompressionConfigurationProvider<T>,
    @Named("dataChannelMedium") private val dataChannelMedium: DataChannelMedium,
) {
    fun create(stream: DestinationStream): BufferedFormattingWriter<T> {
        val underlying: ManagedByteArrayOutputStream =
            if (dataChannelMedium == DataChannelMedium.SOCKET) {
                PooledByteArrayOutputStream()
            } else {
                StandardByteArrayOutputStream()
            }

        val processor =
            compressionConfigurationProvider.objectStorageCompressionConfiguration.compressor
        val wrapping = processor.wrapper.invoke(underlying)
        val writer = writerFactory.create(stream, wrapping)
        return BufferedFormattingWriter(writer, underlying, processor, wrapping)
    }
}

class BufferedFormattingWriter<T : OutputStream>(
    private val writer: ObjectStorageFormattingWriter,
    private val buffer: ManagedByteArrayOutputStream,
    private val streamProcessor: StreamProcessor<T>,
    private val wrappingBuffer: T
) : ObjectStorageFormattingWriter {
    // An empty buffer is not a guarantee of a non-empty
    // file, some writers (parquet) start with a
    // header. Avoid writing empty files by requiring
    // both 0 bytes AND 0 rows.
    private val rowsAdded = AtomicLong(0)
    val bufferSize: Int
        get() =
            if (rowsAdded.get() == 0L) {
                0
            } else buffer.size()

    override fun accept(record: DestinationRecordRaw) {
        writer.accept(record)
        rowsAdded.incrementAndGet()
    }

    fun takeBytes(): ByteArray? {
        wrappingBuffer.flush()
        if (bufferSize == 0) {
            return null
        }

        val bytes = buffer.extractBytes()
        buffer.resetBuffer()
        return bytes
    }

    fun finish(): ByteArray? {
        writer.flush()
        writer.close()
        streamProcessor.partFinisher.invoke(wrappingBuffer)
        return if (bufferSize > 0) {
            buffer.extractBytes()
        } else {
            null
        }
    }

    override fun flush() {
        writer.flush()
        wrappingBuffer.flush()
    }

    override fun close() {
        writer.close()
    }
}
/**
 * Re-uses large byte arrays to cut GC pressure when we generate many S3 parts. Keep at most 512 MiB
 * of slabs in the pool.
 */
object ByteArrayPool {
    private const val MAX_POOL_BYTES = 512 * 1024 * 1024
    private val q = ConcurrentLinkedDeque<ByteArray>()

    fun borrow(minCapacity: Int): ByteArray {
        while (true) {
            val buf = q.pollFirst() ?: return ByteArray(minCapacity)
            if (buf.size >= minCapacity) return buf
            // slab too small, drop it and try again
        }
    }

    fun recycle(buf: ByteArray) {
        val current = q.sumOf { it.size }.toLong()
        if (current + buf.size <= MAX_POOL_BYTES) q.addFirst(buf)
    }
}

class PooledByteArrayOutputStream(private val minCapacity: Int = 32 * 1024) :
    ManagedByteArrayOutputStream(0) {
    /** Borrow a new array exactly sized to `count`, copy data, return it. */
    init {
        buf = ByteArrayPool.borrow(minCapacity)
    }

    override fun extractBytes(): ByteArray =
        ByteArray(count).also { System.arraycopy(buf, 0, it, 0, count) }

    /** Reset *and* recycle the previous backing buffer. */
    override fun resetBuffer() {
        val old = buf
        buf = ByteArrayPool.borrow(minCapacity)
        reset()
        ByteArrayPool.recycle(old)
    }
}
