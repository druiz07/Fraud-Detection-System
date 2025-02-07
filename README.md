# ✨ Team 1: Fraud Detection System ✨

## 🔎 Overview

Welcome to the **Fraud Detection System** project! 🚀 Imagine a world where fraudsters think they can outsmart the system—but not on our watch! ⚡️ Our mission? To **detect and flag suspicious transactions** in real-time using Java, Spring Boot, and multithreading magic. Let's build a secure and intelligent system together!

## 📚 System Features

### 👤 Users & Transactions Management

- A user can have **multiple bank accounts**.
- Each bank account can have **multiple transactions**.
- Transactions are stored using **collections (List or Map)**.

### ⚠️ Fraud Detection Rules

- If a **single account** makes **more than 5 transactions within a minute**, it is flagged.
- If a **transaction amount exceeds \$5000**, it is flagged.
- If **multiple accounts from the same user** transfer money to the same recipient within **5 minutes**, all are flagged.

### 🔄 Real-time Monitoring Using Threads

- Uses **multithreading** to simulate real-time transactions.
- A **background thread** checks transactions **every 10 seconds** for fraud detection.

---

## 🌟 Team Distribution (3 Members)

- **👤 User & Account Management:** Maist
    - Develops and manages the **User** and **Account** models.
    - Implements logic for **creating and managing users and accounts**.
    - Designs and maintains the **services** responsible for storing and handling user and account data.
    - Develops the **REST API controllers** for account and user operations.

- **💳 Transaction Processing:** Sergio
    - Implements the **Transaction** model and its operations.
    - Develops logic for **storing, processing, and handling transactions**.
    - Ensures transactions are properly linked to accounts.

- **🔒 Fraud Detection System:** Daniel (Leader)
    - Designs and implements the **fraud detection algorithms**.
    - Uses **multithreading** to check transactions in real-time.
    - Develops the system for **flagging suspicious activity**.

---

### Project Structure
(add screenshot)

---

## 📄 User & Account Management by Maist

### 🏦 Account Model

- The `Account` class represents a **bank account** and includes:
    - `id`: Unique identifier for the account.
    - `userId`: Links the account to a specific user.
    - `balance`: Holds the account balance.

### 👤 User Model

- The `User` class represents a **bank user** and includes:
    - `id`: Unique identifier for the user.
    - `name`: The user’s name.
    - `monthlyIncome`: The user's income for fraud analysis.
    - `creditScore`: A measure for potential risk assessment.

### 🛠️ Account Service

- `AccountService` is responsible for:
    - Storing accounts using a `Map<Long, Account>`.
    - Creating accounts and assigning unique IDs.

### 👷️ User Service

- `UserService` manages:
    - Storing users in a `Map<Long, User>`.
    - Registering users and assigning unique IDs.

### 🛡️ Account & User Controllers

- `AccountController` and `UserController` handle API endpoints:
    - `/users/register`: Registers a new user.
    - `/accounts`: Placeholder for account management endpoints.

---

## 💳 Transaction Processing by Sergio

### 🏦 Transaction Model
- The `Transaction` class represents a **banking transaction** and contains:
  - `id`: A unique identifier for the transaction.
  - `amount`: The amount of the transaction.
  - `flagged`: A flag indicating whether the transaction has been marked as suspicious.
  - `date`: The date and time when the transaction was executed.
  - `accountPay`: A reference to the account initiating the payment.
  - `accountRecieve`: A reference to the account receiving the payment.
- Additionally, it includes the `execute()` method which performs the transaction by updating the balances of the associated accounts (i.e., debiting the payer and crediting the receiver).

### 🛠️ Transaction Service
- `TransactionService` is responsible for:
  - **Storage:**  
    Maintaining an in-memory list (e.g., a `List<Transaction>`) of all transactions.
  - **Creation and Execution:**  
    - Creating new transactions by properly linking the payer and receiver accounts.
    - Assigning a unique identifier and setting the execution timestamp.
    - Executing the transaction, which involves updating the balances of the corresponding accounts.
  - **Data Retrieval:**  
    Providing methods to retrieve all transactions or search for a specific transaction by its ID.
  - **Real-Time Simulation:**  
    Starting a separate thread that generates random transactions at random intervals, thereby simulating real-time activity.

### 🛡️ Transaction Controller
- `TransactionController` exposes the following REST endpoints:
  - **GET `/transactions`:**  
    Retrieves all recorded transactions.
  - **GET `/transactions/{id}`:**  
    Retrieves a specific transaction by its identifier.
  - **POST `/transactions/{idPay}/{idReceive}`:**  
    Creates a new transaction between the payer (`idPay`) and the receiver (`idReceive`), with transaction details provided in the request body.
  - **GET `/transactions/startSimulation`:**  
    Starts the simulation of real-time transactions.

---

## 🔒 Fraud Detection System by Daniel (Leader)

### 🏦 FraudDetectionSystem Model
- The `FraudDetectionSystem` class implements the core rules for detecting fraudulent transactions:
  - **Multiple Transactions in One Minute:**  
    Checks if an account performs more than 5 transactions within a 60-second interval.
  - **High-Value Transaction:**  
    Flags any transaction where the amount exceeds $5000.
  - **Multiple Transfers to the Same Recipient:**  
    Flags instances when multiple accounts associated with the same user transfer money to the same recipient within a 5-minute period.
    
### 🛠️ Fraud Detection Service  
- `FraudDetectionService` is responsible for:  
  - **Continuous Monitoring:**  
    A background thread that runs every **10 seconds** to scan for fraudulent transactions.  
  - **Rule-Based Detection:**  
    - Identifies accounts making **more than 5 transactions in one minute**.  
    - Flags transactions **exceeding $5000**.  
    - Detects when multiple accounts from the same user send money to **the same recipient within 5 minutes**.  
  - **Flagging & Reporting:**  
    - Updates flagged transactions.  
    - Stores flagged transactions for auditing and reporting purposes.  

### 🛡️ Fraud Detection Controller  
- `FraudDetectionController` exposes the following REST endpoints:  
  - **POST `/fraud/checkFraud`:**  
    Manually triggers fraud detection and flags suspicious transactions. 
---

## 🛠️ Issues Encountered

1. **Problem with making transactions on Postman**
    - **Issue:** Faced difficulties in processing transactions correctly.
    - **Solution:** Reviewed the code and rechecked the logic to identify and fix the issue.
    - 
2. **Problem with 3rd fraud condition**
   - **Isue** Transactions were not marked as suspicious.
   - **Solution** Refactoring checked method to set transactions as true.

---

### Git Implementation
<img width="760" alt="image" src="https://github.com/user-attachments/assets/5c430681-669e-4303-8942-e45284ccb788" />
<img width="760" alt="image" src="https://github.com/user-attachments/assets/a62a5cd9-ce26-4aad-8bf5-39a04b414b26" />
<img width="760" alt="image" src="https://github.com/user-attachments/assets/3d585d1a-d59e-4101-8d03-4d786e69f761" />

---

## 🎭 Tech Stack

| 🚀 Tech | 🔍 Description |
| ---- | ------------------------------------ |
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) | Backend development |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) | Framework for building microservices |
| ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) | Dependency management |

---
