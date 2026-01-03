# 🧑‍💼 Employee Management System – Spring Boot

A **Spring Boot REST API** for managing employees with **CRUD operations**, **validation**, **Swagger documentation**, **exception handling**, and **MySQL integration**.

---

## 🚀 Features

* ✅ Create, Read, Update, Delete Employees
* ✅ Validation using Jakarta Validation
* ✅ Prevent duplicate employee names
* ✅ Custom Global Exception Handling
* ✅ Swagger (OpenAPI) Documentation
* ✅ Enum support for Employee Roles
* ✅ DTO + Builder pattern
* ✅ Lombok for boilerplate reduction
* ✅ MySQL database with JPA & Hibernate

---

## 🛠️ Tech Stack

* **Java** 21
* **Spring Boot** 4.x
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Lombok**
* **Spring Validation**
* **Swagger / OpenAPI (springdoc)**

---

## 📁 Project Structure

```
src/main/java/com/ecommerce/employee
│
├── controller
│   └── EmployeeController.java
│
├── service
│   ├── EmployeeService.java
│   └── impl/EmployeeServiceImpl.java
│
├── repository
│   └── EmployeeRepository.java
│
├── entity
│   └── Employee.java
│
├── dto
│   ├── EmployeeRequestDTO.java
│   └── EmployeeResponseDTO.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   └── DuplicateResourceException.java
│
├── model
│   └── EmployeeRole.java
│
└── EmployeeApplication.java
```

---

## 🧾 Employee Fields

| Field           | Type                          |
| --------------- | ----------------------------- |
| id              | Long                          |
| name            | String (unique)               |
| age             | int                           |
| joinDate        | LocalDate (past or present)   |
| projectJoinDate | LocalDate (present or future) |
| salary          | double                        |
| role            | Enum                          |

---

## 🔐 Validation Rules

* `name` → required
* `age` → minimum 18
* `joinDate` → past or today
* `projectJoinDate` → today or future
* `salary` → positive
* `role` → enum value only

---

## 📌 Employee Roles (Enum)

```java
DEVELOPER
MANAGER
TESTER
HR
```

---

## 📚 API Endpoints

### ➕ Create Employee

```
POST /api/employees
```

**Request Body**

```json
{
  "name": "Rahul Sharma",
  "age": 26,
  "joinDate": "2023-08-15",
  "projectJoinDate": "2026-01-05",
  "salary": 50000,
  "role": "DEVELOPER"
}
```

---

### 📄 Get All Employees

```
GET /api/employees
```

---

### 🔍 Get Employee by ID

```
GET /api/employees/{id}
```

---

### ✏️ Update Employee

```
PUT /api/employees/{id}
```

---

### ❌ Delete Employee

```
DELETE /api/employees/{id}
```

---

### 💰 Get Employees by Salary

```
GET /api/employees/salary/{salary}
```

Example:

```
GET /api/employees/salary/50000
```

---

## ❗ Error Handling

Handled globally using `@RestControllerAdvice`.

### Validation Error Example

```json
{
  "projectJoinDate": "Project join date must be today or future"
}
```

### Duplicate Employee Error

```json
"Employee already exists with name: Rahul Sharma"
```

---

## 📖 Swagger API Documentation

After running the application, open:

```
http://localhost:8082/swagger-ui.html
```

or

```
http://localhost:8082/swagger-ui/index.html
```

---

## 🗄️ Database Configuration

**MySQL**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

```bash
git clone <repository-url>
cd employee
./gradlew bootRun
```

or run `EmployeeApplication` from IDE.

---

## 🧠 Interview Highlights

* Clean layered architecture (Controller → Service → Repository)
* DTO separation
* Validation at API boundary
* Centralized exception handling
* Swagger-documented APIs
* Database + application level uniqueness checks
---

## 👨‍💻 Author

**Kirtesh Admute**
Spring Boot | Backend Developer
