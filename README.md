# Fraud-Detection-System

## Overview
A bank needs a fraud detection system that monitors transactions in real-time and detects suspicious activities based on predefined rules.


## Team Distribution (3 Members)
- **By Maist: User & Account Management** Creates users, accounts, and handles deposits/withdrawals. 
- **By Sergio: Transaction Processing** Implements transaction handling and storage using collections.
- **By Daniel: Fraud Detection System** Develops fraud detection logic and runs it using threads.

---

## User & Account Management (Maist)
### Account Model
- The `Account` class represents a bank account and includes:
    - `id`: Unique identifier for the account.
    - `userId`: Links the account to a specific user.
    - `balance`: Holds the account balance.

### User Model
- The `User` class represents a bank user and includes:
    - `id`: Unique identifier for the user.
    - `name`: The user’s name.
    - `monthlyIncome`: The user's income for fraud analysis.
    - `creditScore`: A measure for potential risk assessment.

### Account Service
- `AccountService` is responsible for:
    - Storing accounts using a `Map<Long, Account>`.
    - Creating accounts and assigning unique IDs.

### User Service
- `UserService` manages:
    - Storing users in a `Map<Long, User>`.
    - Registering users and assigning unique IDs.

### Account & User Controllers
- `AccountController` and `UserController` handle API endpoints:
    - `/users/register`: Registers a new user.
    - `/accounts`: Placeholder for account management endpoints.

---

## Transaction Processing (Sergio)

## Fraud Detection System (Daniel)

## Built With
