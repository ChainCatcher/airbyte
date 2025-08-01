# Drift

## Overview

The Drift source supports Full Refresh syncs. That is, every time a sync is run, Airbyte will copy all rows in the tables and columns you set up for replication into the destination in a new table.

### Output schema

Several output streams are available from this source:

- [Accounts](https://devdocs.drift.com/docs/account-model)
- [Conversations](https://devdocs.drift.com/docs/conversation-model)
- [Users](https://devdocs.drift.com/docs/user-model)

If there are more endpoints you'd like Airbyte to support, please [create an issue.](https://github.com/airbytehq/airbyte/issues/new/choose)

### Features

| Feature                       | Supported?  |
| :---------------------------- | :---------- |
| Full Refresh Sync             | Yes         |
| Incremental Sync              | Coming soon |
| Replicate Incremental Deletes | Coming soon |
| SSL connection                | Yes         |
| Namespaces                    | No          |

### Performance considerations

The Drift connector should not run into Drift API limitations under normal usage. Please [create an issue](https://github.com/airbytehq/airbyte/issues) if you see any rate limit issues that are not automatically retried successfully.

## Getting started

### Requirements

- A Drift API token linked to a Drift App with the following scopes:
  - `conversation_read` to access Conversions
  - `user_read` to access Users
  - `account_read` to access Accounts

### Setup guide

#### Authenticate using `Access Token`

- Follow Drift's [Setting Things Up ](https://devdocs.drift.com/docs/quick-start)guide for a more detailed description of how to obtain the API token.

#### Authenticate using `OAuth2.0`

1. Select `OAuth2.0` from `Authorization Method` dropdown
2. Click on `Authenticate your Drift account`
3. Proceed the authentication in order to obtain the `access_token`

## Changelog

<details>
  <summary>Expand to review</summary>

| Version | Date       | Pull Request                                             | Subject                                                                         |
| :------ | :--------- | :------------------------------------------------------- | :------------------------------------------------------------------------------ |
| 0.4.31 | 2025-07-26 | [63987](https://github.com/airbytehq/airbyte/pull/63987) | Update dependencies |
| 0.4.30 | 2025-07-19 | [63545](https://github.com/airbytehq/airbyte/pull/63545) | Update dependencies |
| 0.4.29 | 2025-07-12 | [62982](https://github.com/airbytehq/airbyte/pull/62982) | Update dependencies |
| 0.4.28 | 2025-07-05 | [62755](https://github.com/airbytehq/airbyte/pull/62755) | Update dependencies |
| 0.4.27 | 2025-06-28 | [62430](https://github.com/airbytehq/airbyte/pull/62430) | Update dependencies |
| 0.4.26 | 2025-06-22 | [61990](https://github.com/airbytehq/airbyte/pull/61990) | Update dependencies |
| 0.4.25 | 2025-06-14 | [61286](https://github.com/airbytehq/airbyte/pull/61286) | Update dependencies |
| 0.4.24 | 2025-05-24 | [60398](https://github.com/airbytehq/airbyte/pull/60398) | Update dependencies |
| 0.4.23 | 2025-05-10 | [60022](https://github.com/airbytehq/airbyte/pull/60022) | Update dependencies |
| 0.4.22 | 2025-05-03 | [59445](https://github.com/airbytehq/airbyte/pull/59445) | Update dependencies |
| 0.4.21 | 2025-04-26 | [58866](https://github.com/airbytehq/airbyte/pull/58866) | Update dependencies |
| 0.4.20 | 2025-04-19 | [58319](https://github.com/airbytehq/airbyte/pull/58319) | Update dependencies |
| 0.4.19 | 2025-04-12 | [57841](https://github.com/airbytehq/airbyte/pull/57841) | Update dependencies |
| 0.4.18 | 2025-04-05 | [57235](https://github.com/airbytehq/airbyte/pull/57235) | Update dependencies |
| 0.4.17 | 2025-03-29 | [56482](https://github.com/airbytehq/airbyte/pull/56482) | Update dependencies |
| 0.4.16 | 2025-03-22 | [55952](https://github.com/airbytehq/airbyte/pull/55952) | Update dependencies |
| 0.4.15 | 2025-03-08 | [55300](https://github.com/airbytehq/airbyte/pull/55300) | Update dependencies |
| 0.4.14 | 2025-03-01 | [54980](https://github.com/airbytehq/airbyte/pull/54980) | Update dependencies |
| 0.4.13 | 2025-02-22 | [54435](https://github.com/airbytehq/airbyte/pull/54435) | Update dependencies |
| 0.4.12 | 2025-02-15 | [53727](https://github.com/airbytehq/airbyte/pull/53727) | Update dependencies |
| 0.4.11 | 2025-02-08 | [53348](https://github.com/airbytehq/airbyte/pull/53348) | Update dependencies |
| 0.4.10 | 2025-02-01 | [52822](https://github.com/airbytehq/airbyte/pull/52822) | Update dependencies |
| 0.4.9 | 2025-01-25 | [52344](https://github.com/airbytehq/airbyte/pull/52344) | Update dependencies |
| 0.4.8 | 2025-01-18 | [51641](https://github.com/airbytehq/airbyte/pull/51641) | Update dependencies |
| 0.4.7 | 2025-01-11 | [51096](https://github.com/airbytehq/airbyte/pull/51096) | Update dependencies |
| 0.4.6 | 2024-12-28 | [50540](https://github.com/airbytehq/airbyte/pull/50540) | Update dependencies |
| 0.4.5 | 2024-12-21 | [50007](https://github.com/airbytehq/airbyte/pull/50007) | Update dependencies |
| 0.4.4 | 2024-12-14 | [49484](https://github.com/airbytehq/airbyte/pull/49484) | Update dependencies |
| 0.4.3 | 2024-12-12 | [49159](https://github.com/airbytehq/airbyte/pull/49159) | Update dependencies |
| 0.4.2 | 2024-12-11 | [47674](https://github.com/airbytehq/airbyte/pull/47674) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.4.1 | 2024-08-16 | [44196](https://github.com/airbytehq/airbyte/pull/44196) | Bump source-declarative-manifest version |
| 0.4.0 | 2024-08-15 | [44153](https://github.com/airbytehq/airbyte/pull/44153) | Refactor connector to manifest-only format |
| 0.3.17 | 2024-08-12 | [43897](https://github.com/airbytehq/airbyte/pull/43897) | Update dependencies |
| 0.3.16 | 2024-08-10 | [43624](https://github.com/airbytehq/airbyte/pull/43624) | Update dependencies |
| 0.3.15 | 2024-08-03 | [43119](https://github.com/airbytehq/airbyte/pull/43119) | Update dependencies |
| 0.3.14 | 2024-07-27 | [42624](https://github.com/airbytehq/airbyte/pull/42624) | Update dependencies |
| 0.3.13 | 2024-07-20 | [42188](https://github.com/airbytehq/airbyte/pull/42188) | Update dependencies |
| 0.3.12 | 2024-07-13 | [41771](https://github.com/airbytehq/airbyte/pull/41771) | Update dependencies |
| 0.3.11 | 2024-07-10 | [41347](https://github.com/airbytehq/airbyte/pull/41347) | Update dependencies |
| 0.3.10 | 2024-07-09 | [41300](https://github.com/airbytehq/airbyte/pull/41300) | Update dependencies |
| 0.3.9 | 2024-07-06 | [40889](https://github.com/airbytehq/airbyte/pull/40889) | Update dependencies |
| 0.3.8 | 2024-06-25 | [40299](https://github.com/airbytehq/airbyte/pull/40299) | Update dependencies |
| 0.3.7 | 2024-06-22 | [39976](https://github.com/airbytehq/airbyte/pull/39976) | Update dependencies |
| 0.3.6 | 2024-06-04 | [39007](https://github.com/airbytehq/airbyte/pull/39007) | [autopull] Upgrade base image to v1.2.1 |
| 0.3.5 | 2024-05-20 | [38321](https://github.com/airbytehq/airbyte/pull/38321) | Make compatability with builder |
| 0.3.4 | 2024-05-03 | [37592](https://github.com/airbytehq/airbyte/pull/37592) | Change `last_records` to `last_record` |
| 0.3.3 | 2024-04-19 | [37153](https://github.com/airbytehq/airbyte/pull/37153) | Upgrade to CDK 0.80.0 and manage dependencies with Poetry. |
| 0.3.2 | 2024-04-15 | [37153](https://github.com/airbytehq/airbyte/pull/37153) | Base image migration: remove Dockerfile and use the python-connector-base image |
| 0.3.1 | 2024-04-12 | [37153](https://github.com/airbytehq/airbyte/pull/37153) | schema descriptions |
| 0.3.0 | 2023-08-05 | [29121](https://github.com/airbytehq/airbyte/pull/29121) | Migrate Python CDK to Low Code CDK |
| 0.2.7 | 2023-06-09 | [27202](https://github.com/airbytehq/airbyte/pull/27202) | Remove authSpecification in favour of advancedAuth in specification |
| 0.2.6 | 2023-03-07 | [23810](https://github.com/airbytehq/airbyte/pull/23810) | Prepare for cloud |
| 0.2.5 | 2021-12-14 | [8429](https://github.com/airbytehq/airbyte/pull/8429) | Updated titles and descriptions |
| 0.2.3 | 2021-10-27 | [7247](https://github.com/airbytehq/airbyte/pull/7247) | Migrate to the CDK |
| 0.2.3 | 2021-10-25 | [7337](https://github.com/airbytehq/airbyte/pull/7337) | Added support of `OAuth 2.0` authorisation option |

</details>
