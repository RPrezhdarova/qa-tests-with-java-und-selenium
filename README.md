# 🧪 E-Commerce UI + Admin Automation with Java & Selenium

This project contains automated tests for both **frontend (user-side)** and **backend (admin-side)** workflows of an e-commerce application.  
It uses **Java**, **Selenium WebDriver**, and **TestNG**, structured in a clear **Page Object Model (POM)** format.

---

## ✅ Key Features
- Search for products on the store
- Add products to the shopping cart
- Perform guest checkout with personal and shipping info
- Admin login and order management (filter orders, verify customer names)

### 🎯 Frontend (User Flow)
- Open homepage
- Search product (`Palm Treo Pro`)
- Add product to cart
- Checkout as guest
- Fill personal & shipping info
- Confirm order placed successfully

### 🔐 Backend (Admin Panel)
- Login as admin
- Filter existing order by ID
- Verify order and customer data

---

## 📂 Project Structure 
<img width="224" alt="image" src="https://github.com/user-attachments/assets/e6f64b79-16c9-4cb7-b8e4-2ed103ff9d80" />



## 🚀 Getting Started

### 📦 Prerequisites
- Java JDK 17+
- Maven
- IntelliJ IDEA / VS Code
- Chrome + Chromedriver

### ▶️ Run Tests

From terminal:
`mvn clean test`

Or inside IntelliJ:
- Right-click on OrderProductSuccessfullyTests.java
- Click Run

---

🧪 Test Scenarios
✅ findProductAndAddItToCard()
Simulates a guest user journey:

- Opens homepage
- Searches for Palm Treo Pro
- Adds to cart
- Proceeds through guest checkout
- Fills details & verifies confirmation

✅ AddProductToExistingOrder()
Simulates an admin user:
- Logs into backend with admin/parola123!
- Filters order by ID 98
- Verifies customer name and presence


🧰 Tools Used

| Tool         | Purpose                       |
| ------------ | ----------------------------- |
| Java         | Main programming language     |
| Selenium     | UI automation                 |
| TestNG       | Test framework                |
| POM          | Page Object Model             |
| Maven        | Build & dependency management |
| Git / GitHub | Version control & portfolio   |


