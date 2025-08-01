# Zoho Billing
Zoho Billing is a billing software used by countless organizations across the globe.
Using this connector we can extract data from various streams such as products , invoices , transactions and quotes.
Docs : https://www.zoho.com/billing/api/v1/introduction/#overview

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `region` | `string` | Region.  |  |
| `client_id` | `string` | OAuth Client ID.  |  |
| `client_secret` | `string` | OAuth Client Secret.  |  |
| `refresh_token` | `string` | OAuth Refresh Token.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| Products | product_id | DefaultPaginator | ✅ |  ❌  |
| plans | plan_code | DefaultPaginator | ✅ |  ❌  |
| addons | addon_code | DefaultPaginator | ✅ |  ❌  |
| coupons | coupon_code | DefaultPaginator | ✅ |  ❌  |
| customers | customer_id | DefaultPaginator | ✅ |  ❌  |
| Quotes | estimate_id | DefaultPaginator | ✅ |  ❌  |
| invoices | invoice_id | DefaultPaginator | ✅ |  ❌  |
| expenses | expense_id | DefaultPaginator | ✅ |  ❌  |
| subscriptions | customer_id | DefaultPaginator | ✅ |  ❌  |
| taxes | tax_id | DefaultPaginator | ✅ |  ❌  |
| transactions | transaction_id | DefaultPaginator | ✅ |  ❌  |
| recurring expenses | recurring_expense_id | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.26 | 2025-07-26 | [64076](https://github.com/airbytehq/airbyte/pull/64076) | Update dependencies |
| 0.0.25 | 2025-07-20 | [63653](https://github.com/airbytehq/airbyte/pull/63653) | Update dependencies |
| 0.0.24 | 2025-07-12 | [63187](https://github.com/airbytehq/airbyte/pull/63187) | Update dependencies |
| 0.0.23 | 2025-07-05 | [62706](https://github.com/airbytehq/airbyte/pull/62706) | Update dependencies |
| 0.0.22 | 2025-06-28 | [62255](https://github.com/airbytehq/airbyte/pull/62255) | Update dependencies |
| 0.0.21 | 2025-06-21 | [61776](https://github.com/airbytehq/airbyte/pull/61776) | Update dependencies |
| 0.0.20 | 2025-06-15 | [61193](https://github.com/airbytehq/airbyte/pull/61193) | Update dependencies |
| 0.0.19 | 2025-05-24 | [59984](https://github.com/airbytehq/airbyte/pull/59984) | Update dependencies |
| 0.0.18 | 2025-05-04 | [58954](https://github.com/airbytehq/airbyte/pull/58954) | Update dependencies |
| 0.0.17 | 2025-04-19 | [58539](https://github.com/airbytehq/airbyte/pull/58539) | Update dependencies |
| 0.0.16 | 2025-04-13 | [58046](https://github.com/airbytehq/airbyte/pull/58046) | Update dependencies |
| 0.0.15 | 2025-04-05 | [57372](https://github.com/airbytehq/airbyte/pull/57372) | Update dependencies |
| 0.0.14 | 2025-03-29 | [56837](https://github.com/airbytehq/airbyte/pull/56837) | Update dependencies |
| 0.0.13 | 2025-03-22 | [56331](https://github.com/airbytehq/airbyte/pull/56331) | Update dependencies |
| 0.0.12 | 2025-03-09 | [55654](https://github.com/airbytehq/airbyte/pull/55654) | Update dependencies |
| 0.0.11 | 2025-03-01 | [54639](https://github.com/airbytehq/airbyte/pull/54639) | Update dependencies |
| 0.0.10 | 2025-02-15 | [54114](https://github.com/airbytehq/airbyte/pull/54114) | Update dependencies |
| 0.0.9 | 2025-02-08 | [53590](https://github.com/airbytehq/airbyte/pull/53590) | Update dependencies |
| 0.0.8 | 2025-02-01 | [53119](https://github.com/airbytehq/airbyte/pull/53119) | Update dependencies |
| 0.0.7 | 2025-01-25 | [52553](https://github.com/airbytehq/airbyte/pull/52553) | Update dependencies |
| 0.0.6 | 2025-01-18 | [51933](https://github.com/airbytehq/airbyte/pull/51933) | Update dependencies |
| 0.0.5 | 2025-01-11 | [51468](https://github.com/airbytehq/airbyte/pull/51468) | Update dependencies |
| 0.0.4 | 2024-12-28 | [50836](https://github.com/airbytehq/airbyte/pull/50836) | Update dependencies |
| 0.0.3 | 2024-12-21 | [50392](https://github.com/airbytehq/airbyte/pull/50392) | Update dependencies |
| 0.0.2 | 2024-12-14 | [49451](https://github.com/airbytehq/airbyte/pull/49451) | Update dependencies |
| 0.0.1 | 2024-11-05 | | Initial release by [@ombhardwajj](https://github.com/ombhardwajj) via Connector Builder |

</details>
