# Donut Palace Inventory Management System

Donut Palace is a full-stack inventory management web application built for a small retail bakery.  
It allows staff to manage items and meals, enforce inventory constraints, and simulate purchases through a simple browser interface.

The project emphasizes backend correctness, validation logic, and clear data flow rather than visual complexity.




## Overview

This application models a point-of-sale style inventory system for a donut shop. Users can view available items and meals, add or update inventory, and simulate purchases using a “Buy Now” workflow that adjusts stock levels in real time.

Special attention is given to inventory correctness by enforcing minimum and maximum inventory constraints at both the data and validation layers.

###### See [API documentation](api.md) for endpoint details.

## Features

- Inventory management for items and meals
- Minimum and maximum inventory enforcement using custom validators
- Purchase simulation with success and failure states
- Server-side validation with user-visible error messages
- Sample inventory loaded on first application start
- Simple navigation with Home and About pages

---

## Tech Stack

- Java
- Spring Boot
- Thymeleaf
- H2 Database (file-based persistence)
- HTML / CSS / Bootstrap

---

## Running the Application

### Prerequisites
- Java 17+
- Maven

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/MoToney/donut_palace.git
   cd donut_palace

2. Run the application:

   ```bash 
   mvn spring-boot:run

3. Open a browser and visit:

   ```http://localhost:8080 ```

## Inventory Rules

Each item tracks:

- Current inventory

- Minimum allowed inventory

- Maximum allowed inventory

The application prevents:

- Purchasing items when inventory is zero

- Saving items with inventory below the minimum

- Saving items with inventory above the maximum

Validation is enforced using custom Spring validators and surfaced directly to the UI.

## Sample Data

On first startup, the application seeds example items and meals (such as donuts, croissants, and beverages) if the database is empty.
This ensures the UI is immediately usable without manual setup.

## Limitations

- No authentication or user roles

- UI is intentionally minimal

- Designed for demonstration rather than production deployment

## Future Improvements

- Add user authentication and role-based access

- Add transaction history tracking

- Add REST API documentation

## License

MIT License
## Contact

Maurice Toney Jr. \
mauricetoneyjr@gmail.com