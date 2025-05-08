# 🚚 Concurrent Delivery Management System

This Java project implements a **concurrent system** for managing deliveries in a logistics company that ships products purchased through an e-commerce platform.

<img src="https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png" width="50" height="35" />

---

## 📋 Table of Contents

- [📄 Overview](#overview)
- [🏗️ System Architecture](#system-architecture)
- [📦 Locker States](#locker-states)
- [🗃️ Order Records](#order-records)
- [🔄 System Stages](#system-stages)
- [💻 Requirements](#requirements)
- [⚙️ Compilation and Execution](#compilation-and-execution)
- [👥 Authors](#authors)

---

## 📄 Overview

This system simulates the full order workflow—from preparation to delivery—handling multiple threads that interact with:

- A matrix of lockers
- Order state records
- Probabilities to simulate real-world scenarios

---

## 🏗️ System Architecture

| Process             | Threads | Main Function                               |
|---------------------|---------|---------------------------------------------|
| Order Preparation   | 3       | Assign locker and register new order        |
| Order Dispatch      | 2       | Validate and move to transit or failed      |
| Customer Delivery   | 3       | Confirm or mark delivery as failed          |
| Final Verification  | 2       | Verify delivered orders                     |

---

## 📦 Locker States

Each locker in the matrix can be in one of the following states:

- 🟢 `Empty`: Available for new orders
- 🔵 `Occupied`: Contains an order being prepared
- 🔴 `Out of service`: Cannot be used

Each locker also maintains a usage counter that increments each time it is used.

---

## 🗃️ Order Records

📑 The system maintains the following lists to track order states:

- 📌 Orders in Preparation  
- 🚛 Orders in Transit  
- ✅ Delivered Orders  
- ❌ Failed Orders  
- 🔍 Verified Orders  

---

## 🔄 System Stages

### 1️⃣ Order Preparation

- 🧵 Handled by **3 threads**
- Randomly selects an available locker
- Marks it as occupied and registers the order

### 2️⃣ Order Dispatch

- 🧵 Handled by **2 threads**
- Takes random orders from preparation
- Validates order and user data  
  - ✅ 85% chance → locker is freed, order moves to transit  
  - ❌ 15% chance → locker goes out of service, order is failed

### 3️⃣ Customer Delivery

- 🧵 Handled by **3 threads**
- Randomly selects transit orders  
  - ✅ 90% chance → order is delivered  
  - ❌ 10% chance → order is failed

### 4️⃣ Final Verification

- 🧵 Handled by **2 threads**
- Verifies delivered orders with 95% accuracy  
  - ✅ 95% → moved to verified  
  - ❌ 5% → moved to failed

---

## 💻 Requirements

- ☕ Java JDK 8 or higher
- 🧠 Basic knowledge of concurrent programming
- 💼 IDE such as IntelliJ IDEA, Eclipse, or command line with `javac`

---

## ⚙️ Compilation and Execution

```bash
# Compile
javac Main.java

# Run
java Main
