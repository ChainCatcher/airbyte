#
# Copyright (c) 2023 Airbyte, Inc., all rights reserved.
#

from pathlib import Path

INTERNAL_POETRY_PACKAGES = [
    "airbyte-ci/connectors/auto_merge",
    "airbyte-ci/connectors/pipelines",
    "airbyte-ci/connectors/connectors_insights",
    "airbyte-ci/connectors/connector_ops",
    "airbyte-ci/connectors/connectors_qa",
    "airbyte-ci/connectors/ci_credentials",
    "airbyte-ci/connectors/erd",
    "airbyte-ci/connectors/live-tests",
    "airbyte-ci/connectors/metadata_service/lib",
    "airbyte-ci/connectors/metadata_service/orchestrator",
    "airbyte-integrations/bases/connector-acceptance-test",
]

INTERNAL_POETRY_PACKAGES_PATH = [Path(package) for package in INTERNAL_POETRY_PACKAGES]
