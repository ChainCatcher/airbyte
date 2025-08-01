# Katana
This is the Katana source connector that ingests data from the katana API.

Katana is a real-time cloud inventory platform to manage sales channels, products, and materials to always be ready to meet demands.  You can find more about it here https://katanamrp.com/

This source uses OAuth Bearer Token for authentication. In order to obtain your API token, you must first create an account on Katana and be on their Professional Plan. 

To generate a live API key: log in to your Katana account.  Go to Settings &gt; API. Select Add new API key. You can find more about the API here https://developer.katanamrp.com/reference/api-introduction

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key. API key to use. Find it at https://katanamrp.com/login/ |  |
| `start_date` | `string` | Start date.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| customers | id | DefaultPaginator | ✅ |  ✅  |
| shipping_fee |  | DefaultPaginator | ✅ |  ❌  |
| costs | id | DefaultPaginator | ✅ |  ✅  |
| customer_addresses | id | DefaultPaginator | ✅ |  ✅  |
| variants | id | DefaultPaginator | ✅ |  ✅  |
| tax_rates | id | DefaultPaginator | ✅ |  ✅  |
| suppliers | id | DefaultPaginator | ✅ |  ✅  |
| stocktakes | id | DefaultPaginator | ✅ |  ✅  |
| stock_adjustments | id | DefaultPaginator | ✅ |  ✅  |
| sales_orders | id | DefaultPaginator | ✅ |  ✅  |
| sales_order_fulfillments | id | DefaultPaginator | ✅ |  ❌  |
| sales_order_addresses | id | DefaultPaginator | ✅ |  ✅  |
| recipes | ingredient_variant_id.product_variant_id | DefaultPaginator | ✅ |  ✅  |
| purchase_orders | id | DefaultPaginator | ✅ |  ✅  |
| products | id | DefaultPaginator | ✅ |  ✅  |
| price_lists | id | DefaultPaginator | ✅ |  ❌  |
| inventory | variant_id | DefaultPaginator | ✅ |  ❌  |
| locations | id | DefaultPaginator | ✅ |  ✅  |
| manufacturing_orders | id | DefaultPaginator | ✅ |  ✅  |
| materials | id | DefaultPaginator | ✅ |  ✅  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.31 | 2025-07-26 | [63837](https://github.com/airbytehq/airbyte/pull/63837) | Update dependencies |
| 0.0.30 | 2025-07-19 | [63470](https://github.com/airbytehq/airbyte/pull/63470) | Update dependencies |
| 0.0.29 | 2025-07-12 | [63119](https://github.com/airbytehq/airbyte/pull/63119) | Update dependencies |
| 0.0.28 | 2025-07-05 | [62664](https://github.com/airbytehq/airbyte/pull/62664) | Update dependencies |
| 0.0.27 | 2025-06-28 | [62158](https://github.com/airbytehq/airbyte/pull/62158) | Update dependencies |
| 0.0.26 | 2025-06-21 | [61795](https://github.com/airbytehq/airbyte/pull/61795) | Update dependencies |
| 0.0.25 | 2025-06-14 | [61083](https://github.com/airbytehq/airbyte/pull/61083) | Update dependencies |
| 0.0.24 | 2025-05-24 | [60631](https://github.com/airbytehq/airbyte/pull/60631) | Update dependencies |
| 0.0.23 | 2025-05-10 | [59780](https://github.com/airbytehq/airbyte/pull/59780) | Update dependencies |
| 0.0.22 | 2025-05-03 | [59298](https://github.com/airbytehq/airbyte/pull/59298) | Update dependencies |
| 0.0.21 | 2025-04-26 | [58191](https://github.com/airbytehq/airbyte/pull/58191) | Update dependencies |
| 0.0.20 | 2025-04-12 | [57749](https://github.com/airbytehq/airbyte/pull/57749) | Update dependencies |
| 0.0.19 | 2025-04-05 | [57105](https://github.com/airbytehq/airbyte/pull/57105) | Update dependencies |
| 0.0.18 | 2025-03-29 | [56680](https://github.com/airbytehq/airbyte/pull/56680) | Update dependencies |
| 0.0.17 | 2025-03-22 | [56004](https://github.com/airbytehq/airbyte/pull/56004) | Update dependencies |
| 0.0.16 | 2025-03-08 | [55431](https://github.com/airbytehq/airbyte/pull/55431) | Update dependencies |
| 0.0.15 | 2025-03-01 | [54824](https://github.com/airbytehq/airbyte/pull/54824) | Update dependencies |
| 0.0.14 | 2025-02-22 | [54291](https://github.com/airbytehq/airbyte/pull/54291) | Update dependencies |
| 0.0.13 | 2025-02-15 | [53863](https://github.com/airbytehq/airbyte/pull/53863) | Update dependencies |
| 0.0.12 | 2025-02-08 | [53267](https://github.com/airbytehq/airbyte/pull/53267) | Update dependencies |
| 0.0.11 | 2025-02-01 | [52717](https://github.com/airbytehq/airbyte/pull/52717) | Update dependencies |
| 0.0.10 | 2025-01-25 | [52282](https://github.com/airbytehq/airbyte/pull/52282) | Update dependencies |
| 0.0.9 | 2025-01-18 | [51838](https://github.com/airbytehq/airbyte/pull/51838) | Update dependencies |
| 0.0.8 | 2025-01-11 | [51199](https://github.com/airbytehq/airbyte/pull/51199) | Update dependencies |
| 0.0.7 | 2024-12-28 | [50612](https://github.com/airbytehq/airbyte/pull/50612) | Update dependencies |
| 0.0.6 | 2024-12-21 | [50119](https://github.com/airbytehq/airbyte/pull/50119) | Update dependencies |
| 0.0.5 | 2024-12-14 | [49603](https://github.com/airbytehq/airbyte/pull/49603) | Update dependencies |
| 0.0.4 | 2024-12-12 | [49246](https://github.com/airbytehq/airbyte/pull/49246) | Update dependencies |
| 0.0.3 | 2024-12-11 | [48991](https://github.com/airbytehq/airbyte/pull/48991) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.2 | 2024-10-28 | [47628](https://github.com/airbytehq/airbyte/pull/47628) | Update dependencies |
| 0.0.1 | 2024-10-12 | | Initial release by [@aazam-gh](https://github.com/aazam-gh) via Connector Builder |

</details>
