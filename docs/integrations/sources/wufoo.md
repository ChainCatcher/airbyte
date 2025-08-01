# Wufoo
The Airbyte connector for [Wufoo](https://www.wufoo.com/) enables seamless data integration between Wufoo and various destinations. It extracts form entries, form metadata, and user information from Wufoo via the Wufoo API. This connector helps automate the synchronization of survey and form data with your chosen data warehouse or analytical tools, simplifying data-driven insights and reporting.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key. Your Wufoo API Key. You can find it by logging into your Wufoo account, selecting &#39;API Information&#39; from the &#39;More&#39; dropdown on any form, and locating the 16-digit code. |  |
| `subdomain` | `string` | Subdomain. Your account subdomain/username for Wufoo. |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| forms | Hash | No pagination | ✅ |  ❌  |
| form_comments | CommentId | DefaultPaginator | ✅ |  ❌  |
| form_fields |  | No pagination | ✅ |  ❌  |
| form_entries | EntryId | DefaultPaginator | ✅ |  ❌  |
| reports | Hash | No pagination | ✅ |  ❌  |
| report_entries | EntryId | No pagination | ✅ |  ❌  |
| report_fields |  | No pagination | ✅ |  ❌  |
| report_widgets | Hash | No pagination | ✅ |  ❌  |
| users | Hash | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.30 | 2025-07-26 | [64077](https://github.com/airbytehq/airbyte/pull/64077) | Update dependencies |
| 0.0.29 | 2025-07-20 | [63664](https://github.com/airbytehq/airbyte/pull/63664) | Update dependencies |
| 0.0.28 | 2025-07-12 | [63227](https://github.com/airbytehq/airbyte/pull/63227) | Update dependencies |
| 0.0.27 | 2025-07-05 | [62692](https://github.com/airbytehq/airbyte/pull/62692) | Update dependencies |
| 0.0.26 | 2025-06-28 | [62243](https://github.com/airbytehq/airbyte/pull/62243) | Update dependencies |
| 0.0.25 | 2025-06-21 | [61760](https://github.com/airbytehq/airbyte/pull/61760) | Update dependencies |
| 0.0.24 | 2025-06-15 | [61203](https://github.com/airbytehq/airbyte/pull/61203) | Update dependencies |
| 0.0.23 | 2025-05-24 | [60779](https://github.com/airbytehq/airbyte/pull/60779) | Update dependencies |
| 0.0.22 | 2025-05-10 | [59919](https://github.com/airbytehq/airbyte/pull/59919) | Update dependencies |
| 0.0.21 | 2025-05-04 | [59563](https://github.com/airbytehq/airbyte/pull/59563) | Update dependencies |
| 0.0.20 | 2025-04-26 | [58921](https://github.com/airbytehq/airbyte/pull/58921) | Update dependencies |
| 0.0.19 | 2025-04-19 | [58565](https://github.com/airbytehq/airbyte/pull/58565) | Update dependencies |
| 0.0.18 | 2025-04-12 | [57382](https://github.com/airbytehq/airbyte/pull/57382) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56859](https://github.com/airbytehq/airbyte/pull/56859) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56309](https://github.com/airbytehq/airbyte/pull/56309) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55641](https://github.com/airbytehq/airbyte/pull/55641) | Update dependencies |
| 0.0.14 | 2025-03-01 | [55098](https://github.com/airbytehq/airbyte/pull/55098) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54461](https://github.com/airbytehq/airbyte/pull/54461) | Update dependencies |
| 0.0.12 | 2025-02-15 | [54026](https://github.com/airbytehq/airbyte/pull/54026) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53534](https://github.com/airbytehq/airbyte/pull/53534) | Update dependencies |
| 0.0.10 | 2025-02-01 | [53039](https://github.com/airbytehq/airbyte/pull/53039) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52456](https://github.com/airbytehq/airbyte/pull/52456) | Update dependencies |
| 0.0.8 | 2025-01-18 | [52011](https://github.com/airbytehq/airbyte/pull/52011) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51384](https://github.com/airbytehq/airbyte/pull/51384) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50767](https://github.com/airbytehq/airbyte/pull/50767) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50347](https://github.com/airbytehq/airbyte/pull/50347) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49768](https://github.com/airbytehq/airbyte/pull/49768) | Update dependencies |
| 0.0.3 | 2024-12-12 | [49379](https://github.com/airbytehq/airbyte/pull/49379) | Update dependencies |
| 0.0.2 | 2024-12-11 | [49121](https://github.com/airbytehq/airbyte/pull/49121) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.1 | 2024-11-08 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
