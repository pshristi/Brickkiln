# Brickkiln Plus - Brickkiln Management System

A comprehensive Java Swing-based desktop application for managing brickkiln operations, including employee management, production tracking, sales records, and financial management.

## 📋 Overview

Brickkiln Plus is a management information system designed to help brickkiln factory owners and managers efficiently manage their daily operations. The system provides separate interfaces for owners and managers with different access levels and functionalities.

This is an educational project created for learning Java and database management concepts.

## ✨ Features

### Owner Features
- **Manager Management**: Add, view, and delete manager accounts
- **Work Details Overview**: Monitor overall factory operations
- **Complete System Access**: Full access to all modules and reports

### Manager Features
- **Employee Management**
  - Add, view, and delete employee records
  - Track employee work records
  - Department-wise employee organization
  - View employee details and contact information

- **Customer Management**
  - Add and manage customer records
  - Track customer transactions
  - View customer purchase history
  - Deposit money records

- **Production Management**
  - Add production records
  - Track different product types
  - Monitor production quantities
  - View production history and total production

- **Sales Management**
  - Record sales transactions
  - Track sales by customer
  - View sales history and reports

- **Expenditure Management**
  - Record various expenditures
  - Track factory expenses
  - View expenditure reports

- **Product Management**
  - Add new products
  - Modify product details
  - View product list with rates

## 🏗️ Project Structure

```
Brickkiln/
├── src/
│   └── main/
│       └── java/
│           └── management/
│               ├── database/
│               │   └── DatabaseConnector.java
│               ├── dao/
│               │   ├── EmployeeList.java
│               │   ├── ManagerList.java
│               └── ui/
│                   ├── login/
│                   │   ├── Factory.java (Main Entry Point)
│                   │   ├── OwnerLogin.java
│                   │   └── ManagerLogin.java
│                   ├── sections/
│                   │   ├── OwnerSection.java
│                   │   ├── ManagerSection.java
│                   │   ├── WorkDetails.java
│                   │   ├── EmployeesDetails.java
│                   │   ├── ManagerDetails.java
│                   │   ├── ProductionDetails.java
│                   │   ├── SalesDetails.java
│                   │   └── ExpenditureDetails.java
│                   ├── views/
│                   │   ├── ViewEmployee.java
│                   │   ├── ViewManager.java
│                   │   ├── ViewCostumer.java
│                   │   ├── ViewProduction.java
│                   │   ├── ViewSales.java
│                   │   ├── ViewExpenditure.java
│                   │   ├── ViewProductList.java
│                   │   ├── ViewDepartment.java
│                   │   ├── ViewEmployeeRecord.java
│                   │   ├── ViewCostumerRecord.java
│                   │   ├── ViewTotalProduction.java
│                   │   └── Department.java
│                   └── forms/
│                       ├── AddEmployee.java
│                       ├── AddManager.java
│                       ├── AddCostumer.java
│                       ├── AddProduct.java
│                       ├── AddProduction.java
│                       ├── AddSalesRecord.java
│                       ├── AddExpenditure.java
│                       ├── AddEmployeeRecord.java
│                       ├── AddCostumerRecord.java
│                       ├── DeleteEmployee.java
│                       ├── DeleteManager.java
│                       ├── DeleteCostumer.java
│                       ├── DeleteProduct.java
│                       ├── ModifyProduct.java
│                       └── MoneyDeposit.java
└── README.md
```

## 🛠️ Technology Stack

- **Language**: Java
- **GUI Framework**: Java Swing
- **Database**: MySQL
- **JDBC Driver**: MySQL Connector/J

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

1. **Java Development Kit (JDK)** - Version 8 or higher
   ```bash
   java -version
   ```

2. **MySQL Server** - Version 5.7 or higher
   ```bash
   mysql --version
   ```

3. **MySQL JDBC Driver** - `mysql-connector-java.jar`

## 🔧 Database Setup

1. **Create Database**
   ```sql
   CREATE DATABASE brick;
   USE brick;
   ```

2. **Create Required Tables**

   ```sql
   -- Manager Table
   CREATE TABLE manager (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       password VARCHAR(100) NOT NULL,
       email VARCHAR(100),
       address VARCHAR(255),
       city VARCHAR(100),
       contactno VARCHAR(15)
   );

   -- Employee Table
   CREATE TABLE employee (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       dno INT,
       contactno INT
   );

   -- Employee Work Table
   CREATE TABLE employeework (
       id INT,
       date DATE,
       work VARCHAR(255),
       FOREIGN KEY (id) REFERENCES employee(id)
   );

   -- Customer Table
   CREATE TABLE costumer (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       address VARCHAR(255),
       city VARCHAR(100),
       contactno VARCHAR(15)
   );

   -- Customer Record Table
   CREATE TABLE costumerrecord (
       id INT,
       date DATE,
       deposit INT,
       FOREIGN KEY (id) REFERENCES costumer(id)
   );

   -- Production Table
   CREATE TABLE finalproduction (
       product VARCHAR(100) PRIMARY KEY,
       rate INT
   );

   -- Production Record Table
   CREATE TABLE production (
       id INT AUTO_INCREMENT PRIMARY KEY,
       date DATE,
       product VARCHAR(100),
       quantity INT,
       FOREIGN KEY (product) REFERENCES finalproduction(product)
   );

   -- Sales Table
   CREATE TABLE sales (
       id INT AUTO_INCREMENT PRIMARY KEY,
       date DATE,
       cid INT,
       product VARCHAR(100),
       quantity INT,
       FOREIGN KEY (cid) REFERENCES costumer(id),
       FOREIGN KEY (product) REFERENCES finalproduction(product)
   );

   -- Expenditure Table
   CREATE TABLE expenditure (
       id INT AUTO_INCREMENT PRIMARY KEY,
       date DATE,
       particular VARCHAR(255),
       amount INT
   );
   ```

3. **Configure Database Connection**
   
   Update the database credentials in `src/main/java/management/database/DatabaseConnector.java`:
   ```java
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/brick","root","root");
   ```
   Change `"root"` and `"root"` to your MySQL username and password.

## 🚀 How to Run

### Option 1: Using Command Line, With MySQL Connector

1. **Compile the project**
   ```bash
   cd /path/to/Brickkiln
   javac -cp ".:mysql-connector-java.jar" src/main/java/management/**/*.java
   ```

2. **Run the application**
   ```bash
   java -cp ".:mysql-connector-java.jar:src/main/java" management.ui.login.Factory
   ```

### Option 2: Manual Compilation
```bash
# Create bin directory
mkdir -p bin

# Compile
find src/main/java -name "*.java" | xargs javac -d bin

# Run
cd bin && java management.ui.login.Factory
```

## 👤 Default Credentials

### Owner Login
- **Username**: `OwnerName`
- **Password**: `OwnerPassword`

### Manager Login
- Managers must be added by the Owner first
- Use the credentials created during manager registration

## 📖 Usage Guide

### Getting Started

1. **Launch Application**: Run `Factory.java` to open the main window
2. **Choose Login Type**: Select either "Owner Login" or "Manager Login"
3. **Enter Credentials**: Use appropriate credentials to access the system

### For Owners

1. After logging in, you'll see the Owner Section with options for:
   - **Work Details**
      - View all operations
      - Access all modules
   - **Manager Management**
      - Add managers
      - View managers
      - Delete managers

### For Managers

1. After logging in, access various management modules:
   - **Employees**: Employee Management
      - Add/View/Delete employees
      - Department organization
      - Work records
   - **Customers**: Handle customer relationships
      - Add/View/Delete customers
      - Track transactions
      - Money deposits
   - **Production**: Track manufacturing
      - Add production records
      - View production history
      - Product management
   - **Sales**: Sales Management
      - Record sales
      - View sales history
   - **Expenditure**: Monitor expenses
      - Record expenses
      - View expenditure reports

## 📋 Navigation Flow

```
Start
  ↓
Factory (Choose Owner/Manager)
  ↓
Login Screen
  ↓
Dashboard (Owner Section / Manager Section)
  ↓
Work Details → [Employees | Sales | Production | Expenditure]
  ↓
CRUD Operations (Add | View | Modify | Delete)
```

## 🎨 UI Features

- Clean and intuitive Swing-based interface
- Consistent Georgia font styling throughout
- Gray-themed buttons for better visibility
- Table views for data display with scroll support
- Form validation and error messages
- Modal dialogs for confirmations and alerts

## 🔐 Security Notes

⚠️ **Important**: This is a learning project and includes basic security implementations:
- Owner credentials are hardcoded (should be stored securely in production)
- Manager credentials are validated against database
- Passwords are stored in plain text (should use hashing in production)
- No session management or audit logging

## 🔧 Common Commands

### Check Java Version
```bash
java -version  # Should be 8 or higher
```

### Check MySQL Status
```bash
systemctl status mysql    # Linux
mysql.server status       # Mac
```

### View Compiled Classes
```bash
find bin -name "*.class"
```

## 🤝 Contributing

This is a learning project. If you'd like to enhance it:
1. Add proper authentication and authorization
2. Implement password hashing
3. Add data validation and sanitization
4. Improve error handling
5. Add unit tests
6. Implement logging mechanism
7. Add backup and restore features

## 🐛 Known Limitations

- Hardcoded owner credentials
- No password encryption
- Basic error handling
- No audit trail
- Limited data validation
- No multi-user session management
- Absolute layout usage (not responsive)

## 👤 Maintainer

**Shristi Pathak**
- LinkedIn: [@shristi-pathak](https://www.linkedin.com/in/shristi-pathak/)

---

**Note**: This project was developed as a learning exercise to understand Java Swing, JDBC, and basic business application development. It demonstrates fundamental concepts of desktop application development with database integration.

