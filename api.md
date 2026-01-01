# Donut Palace REST API Documentation

This document describes the REST-style API exposed by the Donut Palace Inventory Management System. The API is used internally by the web application and documents the core backend workflows for managing inventory and simulating purchases.

The API is designed for clarity and correctness rather than public consumption, and emphasizes validation, constraint enforcement, and predictable behavior.

---

## Base URL

When running locally, all endpoints are served from:

```
http://localhost:8080
```

---

## Data Models

### Item

Represents an individual inventory item (e.g., donuts, croissants, beverages).

```json
{
  "id": 1,
  "name": "Glazed Donut",
  "inv": 5,
  "minInv": 1,
  "maxInv": 10,
  "price": 0.99
}
```

Field descriptions:

* `id`: Unique identifier
* `name`: Item name
* `inv`: Current inventory level
* `minInv`: Minimum allowed inventory
* `maxInv`: Maximum allowed inventory
* `price`: Unit price

---

### Meal

Represents a sellable meal composed of one or more items.

```json
{
  "id": 1,
  "name": "Dozen Glazed Donuts",
  "price": 10.00,
  "inv": 15
}
```

---

## Endpoints

### Get All Items

Returns all inventory items.

**Request**

```http
GET /items
```

**Response**

```json
[
  {
    "id": 1,
    "name": "Glazed Donut",
    "inv": 5,
    "minInv": 1,
    "maxInv": 10,
    "price": 0.99
  }
]
```

**Notes**

* Used to populate the main inventory table
* Inventory values always respect min/max constraints

---

### Create or Update Item

Creates a new inventory item or updates an existing one.

**Request**

```http
POST /items
Content-Type: application/json
```

```json
{
  "name": "Chocolate Donut",
  "inv": 10,
  "minInv": 2,
  "maxInv": 20,
  "price": 1.49
}
```

**Response**

```json
{
  "id": 2,
  "name": "Chocolate Donut",
  "inv": 10,
  "minInv": 2,
  "maxInv": 20,
  "price": 1.49
}
```

**Validation Rules**

* `inv` must be between `minInv` and `maxInv`
* Violations result in a `400 Bad Request`

---

### Purchase Item

Simulates purchasing an item by decrementing inventory by one.

**Request**

```http
POST /items/{id}/purchase
```

**Success Response**

```json
{
  "message": "Purchase successful",
  "remainingInventory": 4
}
```

**Failure Response**

```json
{
  "error": "Inventory unavailable"
}
```

**Behavior**

* Inventory is reduced by one on success
* Inventory cannot go below zero
* Associated items are not affected

---

### Get All Meals

Returns all available meals.

**Request**

```http
GET /meals
```

**Response**

```json
[
  {
    "id": 1,
    "name": "Dozen Glazed Donuts",
    "price": 10.00,
    "inv": 15
  }
]
```

---

### Purchase Meal

Simulates purchasing a meal by decrementing its inventory.

**Request**

```http
POST /meals/{id}/purchase
```

**Success Response**

```json
{
  "message": "Purchase successful",
  "remainingInventory": 14
}
```

**Failure Response**

```json
{
  "error": "Inventory unavailable"
}
```

---

## Error Handling

The API uses standard HTTP status codes:

* `200 OK` — Request successful
* `400 Bad Request` — Validation failure
* `404 Not Found` — Resource not found
* `409 Conflict` — Inventory constraint violation

Validation errors include descriptive messages suitable for display in the UI.

---

## Notes

* This API is currently used internally by the server-rendered UI (Thymeleaf).
* Authentication and authorization are intentionally omitted for simplicity.
* Endpoints are designed to be easily extended into a public REST API if needed in the future.
