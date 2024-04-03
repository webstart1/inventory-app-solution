# Inventory App Solution
Description- this solution uses spring cloud, to implement SOA based solution.
Gateway is used as loadbalancer and auth, which authenticates request via iam service to grant access
via JWT token.

Note- Due to time constraint, solution isn't implemented in detail, logging, and code review is yet to be including

### Framework used
* spring boot 3,
* spring cloud 2022.0.1

### Modules
1. App Gateway
2. App registry
3. IAM Service
4. Inventory Service
5. Stock Service

## Installation
Maven import project in IntelliJ IDE and start each service as below
* App registry
* App Gateway
* IAM Service
* .. other services

### How to register user and get token
IAM Service handles JWT token issue and validation

Register User example
```
POST 'http://localhost:8080/auth/register'
body
{
    "name": "ram",
    "email": "ram@gmail.com"
    "password": "ram123"
}

```

Generate token example

```
POST 'http://localhost:9898/auth/token' 
body
{
{
    "username": "ram",
    "password": "ram123"
}
}
```
#### Inventory Service CRUD

```
http://localhost:8080/inventory/
http://localhost:8080/inventory/addInventory
... check controller for more endpoints
```

#### Stock Service CRUD

```
http://localhost:8080/stock
...check controller for more endpoints
```
