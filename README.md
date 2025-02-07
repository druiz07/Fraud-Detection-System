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
(add explanation)

---

## 🔒 Fraud Detection System by Daniel (Leader)
(add explanation)

---

## 🛠️ Issues Encountered

1. **Problem with making transactions on Postman**
    - **Issue:** Faced difficulties in processing transactions correctly.
    - **Solution:** Reviewed the code and rechecked the logic to identify and fix the issue.

---

### Git Implementation
(add screenshot)

---

## 🎭 Tech Stack

| 🚀 Tech | 🔍 Description |
| ---- | ------------------------------------ |
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) | Backend development |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) | Framework for building microservices |
| ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) | Dependency management |

---