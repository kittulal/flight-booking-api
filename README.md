# ✈️ Krish Airways – Flight Ticket Booking API

A Spring Boot–based REST API for managing flight ticket bookings, passengers, and payments.

This service allows consumers to:
- Create flight bookings
- Retrieve booking details
- List passengers by flight
- Check booking status
- Manage payments

---

## 🧰 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web (REST)
- Spring Data JPA (Hibernate)
- MySQL
- Maven

---

## 🌐 Base URL & Context Path

This application uses a **context path**.

```
http://localhost:8080/krish-airways
```

All APIs are exposed under versioned endpoints:

```
/api/v1
```

### ✅ Example Full Endpoint
```
http://localhost:8080/krish-airways/api/v1/bookings/{bookingReference}
```

---

## 📌 API Endpoints Overview

| Feature | Method | Endpoint |
|------|------|------|
Create Booking | POST | `/api/v1/bookings`
Get Booking Details | GET | `/api/v1/bookings/{bookingReference}`
Check Booking Status | GET | `/api/v1/bookings/{bookingReference}/status`
List Passengers by Flight | GET | `/api/v1/flights/{flightNumber}/passengers?journeyDate=YYYY-MM-DD`

---

## ✈️ 1️⃣ Create Flight Booking

### Endpoint
```
POST /krish-airways/api/v1/bookings
```

### Request Body
```json
{
  "flightNumber": "AI-203",
  "journeyDate": "2026-02-15",
  "passengers": [
    {
      "firstName": "Rahul",
      "lastName": "Sharma",
      "dateOfBirth": "1990-08-15",
      "gender": "MALE",
      "nationality": "INDIAN",
      "passportNumber": "N1234567",
      "email": "rahul.sharma@gmail.com",
      "phoneNumber": "9876543210",
      "seatNumber": "12A",
      "passengerType": "ADULT"
    }
  ],
  "payment": {
    "amount": 7500.00,
    "currency": "INR",
    "paymentMethod": "UPI",
    "upiId": "rahul@upi"
  }
}
```

---

## 📄 2️⃣ Get Booking Details

### Endpoint
```
GET /krish-airways/api/v1/bookings/543CB862
```

---

## 🔍 3️⃣ Check Booking Status

### Endpoint
```
GET /krish-airways/api/v1/bookings/543CB862/status
```

---

## 👥 4️⃣ List Passengers by Flight & Date

### Endpoint
```
GET /krish-airways/api/v1/flights/AI-203/passengers?journeyDate=2026-02-15
```

---

## 🚀 Running the Application

```bash
gradlew.bat clean build
gradlew.bat bootRun
```

Application starts at:
```
http://localhost:8080/krish-airways
```

---

## 👨‍💻 Author

Krish Airways Backend Team
