# SimpleCast
Say hello to the modern end-to-end podcasting platform. Simplecast remains the easiest way to get audio out to the world—with one-click publishing to Apple Podcasts Apple Podcasts , Spotify Spotify, or wherever your audience listens—and the best way for podcasters to cash in on their content.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_token` | `string` | API Token. API token to use. Find it at your Private Apps page on the Simplecast dashboard. |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| podcasts | id | DefaultPaginator | ✅ |  ❌  |
| episodes | id | DefaultPaginator | ✅ |  ❌  |
| analytics |  | DefaultPaginator | ✅ |  ❌  |
| analytics_downloads | id | No pagination | ✅ |  ❌  |
| analytics_podcasts_listeners | id | No pagination | ✅ |  ❌  |
| categories |  | DefaultPaginator | ✅ |  ❌  |
| distribution_channels |  | DefaultPaginator | ✅ |  ❌  |
| timezones | value | No pagination | ✅ |  ❌  |
| analytics_episodes | id | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.28 | 2025-07-19 | [63642](https://github.com/airbytehq/airbyte/pull/63642) | Update dependencies |
| 0.0.27 | 2025-07-05 | [62669](https://github.com/airbytehq/airbyte/pull/62669) | Update dependencies |
| 0.0.26 | 2025-06-28 | [61460](https://github.com/airbytehq/airbyte/pull/61460) | Update dependencies |
| 0.0.25 | 2025-05-24 | [60535](https://github.com/airbytehq/airbyte/pull/60535) | Update dependencies |
| 0.0.24 | 2025-05-10 | [60154](https://github.com/airbytehq/airbyte/pull/60154) | Update dependencies |
| 0.0.23 | 2025-05-04 | [59637](https://github.com/airbytehq/airbyte/pull/59637) | Update dependencies |
| 0.0.22 | 2025-04-27 | [58992](https://github.com/airbytehq/airbyte/pull/58992) | Update dependencies |
| 0.0.21 | 2025-04-19 | [58401](https://github.com/airbytehq/airbyte/pull/58401) | Update dependencies |
| 0.0.20 | 2025-04-12 | [57972](https://github.com/airbytehq/airbyte/pull/57972) | Update dependencies |
| 0.0.19 | 2025-04-05 | [57470](https://github.com/airbytehq/airbyte/pull/57470) | Update dependencies |
| 0.0.18 | 2025-03-29 | [56884](https://github.com/airbytehq/airbyte/pull/56884) | Update dependencies |
| 0.0.17 | 2025-03-22 | [56264](https://github.com/airbytehq/airbyte/pull/56264) | Update dependencies |
| 0.0.16 | 2025-03-09 | [55649](https://github.com/airbytehq/airbyte/pull/55649) | Update dependencies |
| 0.0.15 | 2025-03-01 | [54490](https://github.com/airbytehq/airbyte/pull/54490) | Update dependencies |
| 0.0.14 | 2025-02-15 | [54049](https://github.com/airbytehq/airbyte/pull/54049) | Update dependencies |
| 0.0.13 | 2025-02-08 | [53548](https://github.com/airbytehq/airbyte/pull/53548) | Update dependencies |
| 0.0.12 | 2025-02-01 | [53086](https://github.com/airbytehq/airbyte/pull/53086) | Update dependencies |
| 0.0.11 | 2025-01-25 | [52400](https://github.com/airbytehq/airbyte/pull/52400) | Update dependencies |
| 0.0.10 | 2025-01-18 | [52001](https://github.com/airbytehq/airbyte/pull/52001) | Update dependencies |
| 0.0.9 | 2025-01-11 | [51433](https://github.com/airbytehq/airbyte/pull/51433) | Update dependencies |
| 0.0.8 | 2024-12-28 | [50765](https://github.com/airbytehq/airbyte/pull/50765) | Update dependencies |
| 0.0.7 | 2024-12-21 | [50331](https://github.com/airbytehq/airbyte/pull/50331) | Update dependencies |
| 0.0.6 | 2024-12-14 | [49772](https://github.com/airbytehq/airbyte/pull/49772) | Update dependencies |
| 0.0.5 | 2024-12-12 | [49381](https://github.com/airbytehq/airbyte/pull/49381) | Update dependencies |
| 0.0.4 | 2024-12-11 | [49129](https://github.com/airbytehq/airbyte/pull/49129) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.3 | 2024-10-29 | [47777](https://github.com/airbytehq/airbyte/pull/47777) | Update dependencies |
| 0.0.2 | 2024-10-28 | [47571](https://github.com/airbytehq/airbyte/pull/47571) | Update dependencies |
| 0.0.1 | 2024-10-03 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
