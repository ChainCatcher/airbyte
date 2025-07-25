# Akeneo
The Akeneo Airbyte connector enables seamless data synchronization between Akeneo PIM (Product Information Management) and other platforms. It allows you to easily extract, transform, and load product information from Akeneo to a desired data destination, facilitating efficient management and integration of product catalogs across systems. This connector supports bidirectional data flows, helping businesses maintain accurate and up-to-date product information for various sales channels.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `host` | `string` | Host.  |  |
| `api_username` | `string` | API Username.  |  |
| `password` | `string` | password.  |  |
| `client_id` | `string` | Client ID.  |  |
| `secret` | `string` | Secret.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| products | uuid | DefaultPaginator | ✅ |  ❌  |
| categories  | code | DefaultPaginator | ✅ |  ❌  |
| families | code | DefaultPaginator | ✅ |  ❌  |
| family_variants | code | DefaultPaginator | ✅ |  ❌  |
| attributes | code | DefaultPaginator | ✅ |  ❌  |
| attribute_groups | code | DefaultPaginator | ✅ |  ❌  |
| association_types | code | DefaultPaginator | ✅ |  ❌  |
| channels | code | DefaultPaginator | ✅ |  ❌  |
| locales |  | DefaultPaginator | ✅ |  ❌  |
| currencies | code | DefaultPaginator | ✅ |  ❌  |
| measure_families | code | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.27 | 2025-07-19 | [63483](https://github.com/airbytehq/airbyte/pull/63483) | Update dependencies |
| 0.0.26 | 2025-06-28 | [62151](https://github.com/airbytehq/airbyte/pull/62151) | Update dependencies |
| 0.0.25 | 2025-06-21 | [61098](https://github.com/airbytehq/airbyte/pull/61098) | Update dependencies |
| 0.0.24 | 2025-05-17 | [60691](https://github.com/airbytehq/airbyte/pull/60691) | Update dependencies |
| 0.0.23 | 2025-05-10 | [59887](https://github.com/airbytehq/airbyte/pull/59887) | Update dependencies |
| 0.0.22 | 2025-05-03 | [59341](https://github.com/airbytehq/airbyte/pull/59341) | Update dependencies |
| 0.0.21 | 2025-04-26 | [58731](https://github.com/airbytehq/airbyte/pull/58731) | Update dependencies |
| 0.0.20 | 2025-04-19 | [58289](https://github.com/airbytehq/airbyte/pull/58289) | Update dependencies |
| 0.0.19 | 2025-04-12 | [57594](https://github.com/airbytehq/airbyte/pull/57594) | Update dependencies |
| 0.0.18 | 2025-04-05 | [57165](https://github.com/airbytehq/airbyte/pull/57165) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56585](https://github.com/airbytehq/airbyte/pull/56585) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56142](https://github.com/airbytehq/airbyte/pull/56142) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55422](https://github.com/airbytehq/airbyte/pull/55422) | Update dependencies |
| 0.0.14 | 2025-03-01 | [54901](https://github.com/airbytehq/airbyte/pull/54901) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54253](https://github.com/airbytehq/airbyte/pull/54253) | Update dependencies |
| 0.0.12 | 2025-02-15 | [53899](https://github.com/airbytehq/airbyte/pull/53899) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53402](https://github.com/airbytehq/airbyte/pull/53402) | Update dependencies |
| 0.0.10 | 2025-02-04 | [53151](https://github.com/airbytehq/airbyte/pull/53151) | fix typoe in manifest description |
| 0.0.9 | 2025-02-01 | [52924](https://github.com/airbytehq/airbyte/pull/52924) | Update dependencies |
| 0.0.8 | 2025-01-25 | [52200](https://github.com/airbytehq/airbyte/pull/52200) | Update dependencies |
| 0.0.7 | 2025-01-18 | [51763](https://github.com/airbytehq/airbyte/pull/51763) | Update dependencies |
| 0.0.6 | 2025-01-11 | [51285](https://github.com/airbytehq/airbyte/pull/51285) | Update dependencies |
| 0.0.5 | 2024-12-28 | [50454](https://github.com/airbytehq/airbyte/pull/50454) | Update dependencies |
| 0.0.4 | 2024-12-21 | [50160](https://github.com/airbytehq/airbyte/pull/50160) | Update dependencies |
| 0.0.3 | 2024-12-14 | [49558](https://github.com/airbytehq/airbyte/pull/49558) | Update dependencies |
| 0.0.2 | 2024-12-12 | [49011](https://github.com/airbytehq/airbyte/pull/49011) | Update dependencies |
| 0.0.1 | 2024-10-28 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
