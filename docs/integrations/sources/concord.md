# Concord
This is the setup for the Concord source which ingests data from the concord API.

Concord turns contract data into financial insights. Sign, store and search unlimited contracts https://www.concord.app/

In order to use this source, you must first create a concord account and log in. Then navigate to Automations -> Integrations -> Concord API -> Generate New Key to obtain your API key.

The API is accessible from two environments, sandbox and production. You can learn more about the API here https://api.doc.concordnow.com/

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key.  |  |
| `environment` | `string` | enviornment. The environment from where you want to access the API https://api.doc.concordnow.com/#section/Environments. |  |


## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| agreements | uid | DefaultPaginator | ✅ |  ❌  |
| user_organizations | id | No pagination | ✅ |  ❌  |
| organization | id | No pagination | ✅ |  ❌  |
| folders | id | No pagination | ✅ |  ❌  |
| reports | id | DefaultPaginator | ✅ |  ❌  |
| tags | id | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.31 | 2025-07-26 | [64038](https://github.com/airbytehq/airbyte/pull/64038) | Update dependencies |
| 0.0.30 | 2025-07-19 | [63586](https://github.com/airbytehq/airbyte/pull/63586) | Update dependencies |
| 0.0.29 | 2025-07-12 | [62975](https://github.com/airbytehq/airbyte/pull/62975) | Update dependencies |
| 0.0.28 | 2025-07-05 | [62771](https://github.com/airbytehq/airbyte/pull/62771) | Update dependencies |
| 0.0.27 | 2025-06-28 | [62301](https://github.com/airbytehq/airbyte/pull/62301) | Update dependencies |
| 0.0.26 | 2025-06-21 | [61978](https://github.com/airbytehq/airbyte/pull/61978) | Update dependencies |
| 0.0.25 | 2025-06-14 | [61287](https://github.com/airbytehq/airbyte/pull/61287) | Update dependencies |
| 0.0.24 | 2025-05-24 | [60373](https://github.com/airbytehq/airbyte/pull/60373) | Update dependencies |
| 0.0.23 | 2025-05-10 | [60030](https://github.com/airbytehq/airbyte/pull/60030) | Update dependencies |
| 0.0.22 | 2025-05-03 | [59386](https://github.com/airbytehq/airbyte/pull/59386) | Update dependencies |
| 0.0.21 | 2025-04-26 | [58305](https://github.com/airbytehq/airbyte/pull/58305) | Update dependencies |
| 0.0.20 | 2025-04-12 | [57823](https://github.com/airbytehq/airbyte/pull/57823) | Update dependencies |
| 0.0.19 | 2025-04-05 | [57196](https://github.com/airbytehq/airbyte/pull/57196) | Update dependencies |
| 0.0.18 | 2025-03-29 | [56511](https://github.com/airbytehq/airbyte/pull/56511) | Update dependencies |
| 0.0.17 | 2025-03-22 | [55934](https://github.com/airbytehq/airbyte/pull/55934) | Update dependencies |
| 0.0.16 | 2025-03-08 | [55294](https://github.com/airbytehq/airbyte/pull/55294) | Update dependencies |
| 0.0.15 | 2025-03-01 | [54929](https://github.com/airbytehq/airbyte/pull/54929) | Update dependencies |
| 0.0.14 | 2025-02-22 | [54407](https://github.com/airbytehq/airbyte/pull/54407) | Update dependencies |
| 0.0.13 | 2025-02-15 | [53750](https://github.com/airbytehq/airbyte/pull/53750) | Update dependencies |
| 0.0.12 | 2025-02-08 | [53312](https://github.com/airbytehq/airbyte/pull/53312) | Update dependencies |
| 0.0.11 | 2025-02-01 | [52864](https://github.com/airbytehq/airbyte/pull/52864) | Update dependencies |
| 0.0.10 | 2025-01-25 | [52308](https://github.com/airbytehq/airbyte/pull/52308) | Update dependencies |
| 0.0.9 | 2025-01-18 | [51621](https://github.com/airbytehq/airbyte/pull/51621) | Update dependencies |
| 0.0.8 | 2025-01-11 | [51131](https://github.com/airbytehq/airbyte/pull/51131) | Update dependencies |
| 0.0.7 | 2024-12-28 | [50510](https://github.com/airbytehq/airbyte/pull/50510) | Update dependencies |
| 0.0.6 | 2024-12-21 | [50057](https://github.com/airbytehq/airbyte/pull/50057) | Update dependencies |
| 0.0.5 | 2024-12-14 | [49475](https://github.com/airbytehq/airbyte/pull/49475) | Update dependencies |
| 0.0.4 | 2024-12-12 | [49160](https://github.com/airbytehq/airbyte/pull/49160) | Update dependencies |
| 0.0.3 | 2024-12-11 | [48913](https://github.com/airbytehq/airbyte/pull/48913) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.2 | 2024-11-04 | [48215](https://github.com/airbytehq/airbyte/pull/48215) | Update dependencies |
| 0.0.1 | 2024-10-16 | | Initial release by [@aazam-gh](https://github.com/aazam-gh) via Connector Builder |

</details>
