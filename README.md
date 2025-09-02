# 🚆 Train Ticket Booking System (Spring Boot)

A production-ready **Train Ticket Booking Application** built using **Spring Boot**,  
featuring **REST APIs, DTOs, PDF Ticket Generation, PNR System, and QR-ready tickets**.  
This project demonstrates **clean architecture, DTO usage, service-layer abstraction, and real-world booking workflows**.

---

## ✨ Features

- 🔐 **Customer Booking System**
  - Book tickets by selecting route, coach, and travel date/time.
  - Automatic **PNR generation**.

- 📄 **PDF Ticket Generation**
  - Download professional ticket with:
    - Passenger Details  
    - Train Route (Departure → Arrival)  
    - Travel Date & Time  
    - Coach Type  
    - Total Fare  
    - PNR Number  
  - QR Code

- 📡 **REST APIs**
  - Exposes endpoints for booking creation, fetching by ID, customer bookings, and ticket download.

- 🎯 **DTOs (Request & Response)**
  - Clean separation of request/response models.
  - Prevents exposing entity details directly.

- 🛠️ **Future-Ready**
  - Email integration with PDF attachment.
  - QR-code enabled tickets.

---

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot
- **Database:** MySQL (JPA/Hibernate)
- **PDF Generation:** iText
- **Build Tool:** Maven
- **API Testing:** Postman

---

## 🚀 Setup & Run

### 1️⃣ Clone the Repo
```bash
git clone https://github.com/yourusername/train-ticket-booking.git
cd train-ticket-booking
