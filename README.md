# Cheapest Transfer Route API

This is a Spring Boot application that provides an API to calculate the optimal combination of transfers to maximize the total cost while ensuring the total weight is within a specified limit.

## Features

- POST /transfers: Accepts a list of available transfers and a maximum weight, and calculates the optimal subset of transfers.
- GET /transfers: Returns the selected transfers, their total cost, and total weight.

## Prerequisites
- Java: JDK 11 or later.
- Maven: Installed on your system.
- cURL or Postman: For testing the API endpoints

## How to Build and Run the Application
1. Clone the Repository

```bash
git clone <repository-url>
cd cheapest-transfer-route
```
2. Build and the Application:
```bash
mvn clean install
mvn spring-boot:run
```
3. Access the API The application will run at http://localhost:8080.

## API Endpoints
- POST
``` bash
curl -X POST http://localhost:8080/transfers \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}'
```
- GET
``` bash
curl -X GET http://localhost:8080/transfers 
```

## Example
### input:
```
{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}
```
### output:
``` 
{
  "selectedTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 }
  ],
  "totalCost": 30,
  "totalWeight": 15
}
```
