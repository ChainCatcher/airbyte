# Inflowinventory
As the name suggests , Inflowinventory is an inventory management software.
Using this connector we can extract data from various streams such as customers , productts and sales orders.
Docs : https://cloudapi.inflowinventory.com/docs/index.html#section/Overview

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key.  |  |
| `companyid` | `string` | CompanyID.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| adjustment reasons | adjustmentReasonId | No pagination | ✅ |  ❌  |
| categories | categoryId | No pagination | ✅ |  ❌  |
| currencies | currencyId | No pagination | ✅ |  ❌  |
| customers | customFieldsId | No pagination | ✅ |  ❌  |
| locations | locationId | No pagination | ✅ |  ❌  |
| operation types | operationTypeId | No pagination | ✅ |  ❌  |
| payment terms | paymentTermsId | No pagination | ✅ |  ❌  |
| pricing schemes | pricingSchemeId | No pagination | ✅ |  ❌  |
| products | productId | No pagination | ✅ |  ❌  |
| product cost adjustments | productCostAdjustmentId | No pagination | ✅ |  ❌  |
| purchase orders | purchaseOrderId | No pagination | ✅ |  ❌  |
| sales orders | salesOrderId | No pagination | ✅ |  ❌  |
| stock adjustments | stockAdjustmentId | No pagination | ✅ |  ❌  |
| stock counts | stockCountId | No pagination | ✅ |  ❌  |
| stock transfers | stockTransferId | No pagination | ✅ |  ❌  |
| tax codes | taxCodeId | No pagination | ✅ |  ❌  |
| taxing schemes | taxingSchemeId | No pagination | ✅ |  ❌  |
| team members | teamMemberId | No pagination | ✅ |  ❌  |
| vendors | vendorId | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.29 | 2025-07-26 | [63818](https://github.com/airbytehq/airbyte/pull/63818) | Update dependencies |
| 0.0.28 | 2025-07-19 | [63506](https://github.com/airbytehq/airbyte/pull/63506) | Update dependencies |
| 0.0.27 | 2025-07-12 | [63117](https://github.com/airbytehq/airbyte/pull/63117) | Update dependencies |
| 0.0.26 | 2025-07-05 | [62656](https://github.com/airbytehq/airbyte/pull/62656) | Update dependencies |
| 0.0.25 | 2025-06-21 | [61845](https://github.com/airbytehq/airbyte/pull/61845) | Update dependencies |
| 0.0.24 | 2025-06-14 | [61133](https://github.com/airbytehq/airbyte/pull/61133) | Update dependencies |
| 0.0.23 | 2025-05-24 | [60698](https://github.com/airbytehq/airbyte/pull/60698) | Update dependencies |
| 0.0.22 | 2025-05-10 | [59790](https://github.com/airbytehq/airbyte/pull/59790) | Update dependencies |
| 0.0.21 | 2025-05-03 | [59234](https://github.com/airbytehq/airbyte/pull/59234) | Update dependencies |
| 0.0.20 | 2025-04-26 | [58778](https://github.com/airbytehq/airbyte/pull/58778) | Update dependencies |
| 0.0.19 | 2025-04-19 | [58165](https://github.com/airbytehq/airbyte/pull/58165) | Update dependencies |
| 0.0.18 | 2025-04-12 | [57691](https://github.com/airbytehq/airbyte/pull/57691) | Update dependencies |
| 0.0.17 | 2025-04-05 | [57088](https://github.com/airbytehq/airbyte/pull/57088) | Update dependencies |
| 0.0.16 | 2025-03-29 | [56707](https://github.com/airbytehq/airbyte/pull/56707) | Update dependencies |
| 0.0.15 | 2025-03-22 | [56073](https://github.com/airbytehq/airbyte/pull/56073) | Update dependencies |
| 0.0.14 | 2025-03-08 | [55437](https://github.com/airbytehq/airbyte/pull/55437) | Update dependencies |
| 0.0.13 | 2025-03-01 | [54750](https://github.com/airbytehq/airbyte/pull/54750) | Update dependencies |
| 0.0.12 | 2025-02-22 | [54311](https://github.com/airbytehq/airbyte/pull/54311) | Update dependencies |
| 0.0.11 | 2025-02-15 | [53796](https://github.com/airbytehq/airbyte/pull/53796) | Update dependencies |
| 0.0.10 | 2025-02-08 | [53296](https://github.com/airbytehq/airbyte/pull/53296) | Update dependencies |
| 0.0.9 | 2025-02-01 | [52746](https://github.com/airbytehq/airbyte/pull/52746) | Update dependencies |
| 0.0.8 | 2025-01-25 | [52288](https://github.com/airbytehq/airbyte/pull/52288) | Update dependencies |
| 0.0.7 | 2025-01-18 | [51823](https://github.com/airbytehq/airbyte/pull/51823) | Update dependencies |
| 0.0.6 | 2025-01-11 | [51200](https://github.com/airbytehq/airbyte/pull/51200) | Update dependencies |
| 0.0.5 | 2024-12-28 | [50660](https://github.com/airbytehq/airbyte/pull/50660) | Update dependencies |
| 0.0.4 | 2024-12-21 | [50082](https://github.com/airbytehq/airbyte/pull/50082) | Update dependencies |
| 0.0.3 | 2024-12-14 | [49633](https://github.com/airbytehq/airbyte/pull/49633) | Update dependencies |
| 0.0.2 | 2024-12-12 | [48961](https://github.com/airbytehq/airbyte/pull/48961) | Update dependencies |
| 0.0.1 | 2024-10-29 | | Initial release by [@ombhardwajj](https://github.com/ombhardwajj) via Connector Builder |

</details>
