# High-Concurrency Event Ticketing System

A backend system built using **Spring Boot** that safely handles multiple users attempting to purchase limited event tickets simultaneously without overselling.

---

## 🚀 Project Overview

This project simulates a real-world ticket booking platform where hundreds of users compete to purchase a limited number of tickets at the same time.

The system guarantees:

* No duplicate ticket sales
* Transactional consistency
* Automatic reservation expiration
* Safe concurrent booking

---

## 🧠 Key Engineering Challenges Solved

### ✔ Race Condition Prevention

Implemented **Pessimistic Row-Level Locking** using Spring Data JPA to ensure only one transaction reserves a ticket at a time.

### ✔ Transactional Integrity

Used `@Transactional` boundaries so failed payments automatically rollback ticket reservations.

### ✔ Booking Expiration System

A background scheduler releases reserved tickets if payment is not completed within the expiration window.

### ✔ High Concurrency Simulation

Simulated 100 concurrent users attempting to purchase the same ticket using multithreading tools (`ExecutorService`, `CountDownLatch`).

---

## 🏗️ Architecture

Controller → Service → Repository → Database

Feature-based package structure following clean architecture principles.

---

## 🗄 Database Design

Entities:

* User
* Ticket
* Booking
* Payment

<img width="1245" height="518" alt="ticketing-system db" src="https://github.com/user-attachments/assets/0fd8edc6-e14f-4b34-9255-1af002e39f72" />

---

## ⚡ Concurrency Strategy

* Pessimistic Locking (`PESSIMISTIC_WRITE`)
* Transaction Management
* Hibernate Dirty Checking
* Atomic Booking Flow

---

## 📡 API Endpoints

### User

POST `/users/addUser` — Add New User

### Ticket

POST `/tickets/create` — Create Event Tickets
GET `/tickets/available` — View Available Tickets

### Booking

POST `/booking/purchase` — Reserve Ticket

### Payment

POST `/payment/process` — Complete Payment

---

## 🧪 Concurrency Test Result

```
Threads: 100
Successful Bookings: 1
Failed Attempts: 99
```

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Swagger/OpenAPI

---

## 🎯 Learning Outcomes

* Handling high-concurrency database transactions
* Preventing overselling problems
* Designing transactional workflows
* Backend system architecture

---
