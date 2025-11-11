# Brickkiln Plus - Project Structure

This document describes the organization and structure of the Brickkiln Plus project.

## Directory Layout

```
Brickkiln/
├── src/main/java/management/      # Main source code directory
│   ├── database/                  # Database connectivity layer
│   │   └── DatabaseConnector.java # MySQL connection manager
│   │
│   ├── dao/                       # Data Access Objects
│   │   ├── EmployeeList.java      # Employee CRUD operations
│   │   └── ManagerList.java       # Manager CRUD operations
│   │
│   └── ui/                        # User Interface layer
│       ├── login/                 # Authentication screens
│       │   ├── Factory.java       # Main entry point & login chooser
│       │   ├── OwnerLogin.java    # Owner authentication
│       │   └── ManagerLogin.java  # Manager authentication
│       │
│       ├── sections/              # Main dashboard screens
│       │   ├── OwnerSection.java        # Owner dashboard
│       │   ├── ManagerSection.java      # Manager dashboard
│       │   ├── WorkDetails.java         # Work overview
│       │   ├── EmployeesDetails.java    # Employee management hub
│       │   ├── ManagerDetails.java      # Manager management hub
│       │   ├── ProductionDetails.java   # Production management hub
│       │   ├── SalesDetails.java        # Sales management hub
│       │   └── ExpenditureDetails.java  # Expenditure management hub
│       │
│       ├── views/                 # Data viewing screens
│       │   ├── ViewEmployee.java        # View employee list
│       │   ├── ViewManager.java         # View manager list
│       │   ├── ViewCostumer.java        # View customer list
│       │   ├── CostumersList.java       # Customer list viewer
│       │   ├── ViewProduction.java      # View production records
│       │   ├── ViewSales.java           # View sales records
│       │   ├── ViewExpenditure.java     # View expenditure records
│       │   ├── ViewProductList.java     # View product catalog
│       │   ├── ViewDepartment.java      # View department employees
│       │   ├── ViewEmployeeRecord.java  # View employee work records
│       │   ├── ViewCostumerRecord.java  # View customer records
│       │   ├── ViewTotalProduction.java # View total production
│       │   └── Department.java          # Department selector
│       │
│       └── forms/                 # Data entry and modification forms
│           ├── AddEmployee.java         # Add new employee
│           ├── AddManager.java          # Add new manager
│           ├── AddCostumer.java         # Add new customer
│           ├── AddProduct.java          # Add new product
│           ├── AddProduction.java       # Record production
│           ├── AddSalesRecord.java      # Record sale
│           ├── AddExpenditure.java      # Record expenditure
│           ├── AddEmployeeRecord.java   # Add employee work record
│           ├── AddCostumerRecord.java   # Add customer record
│           ├── DeleteEmployee.java      # Delete employee
│           ├── DeleteManager.java       # Delete manager
│           ├── DeleteCostumer.java      # Delete customer
│           ├── DeleteProduct.java       # Delete product
│           ├── ModifyProduct.java       # Modify product details
│           └── MoneyDeposit.java        # Record customer payment
│
├── compile.sh                     # Compilation script
├── run.sh                        # Run script
├── .gitignore                    # Git ignore patterns
├── PROJECT_STRUCTURE.md          # This file
└── README.md                     # Main documentation
```

## Package Organization

### `management.database`
- **Purpose**: Database connection management
- **Classes**: 
  - `DatabaseConnector`: Provides MySQL database connections

### `management.dao`
- **Purpose**: Data Access Objects for database operations
- **Classes**:
  - `EmployeeList`: CRUD operations for employees
  - `ManagerList`: CRUD operations and authentication for managers

### `management.ui.login`
- **Purpose**: Application entry point and authentication
- **Classes**:
  - `Factory`: Main application entry (contains `main()` method)
  - `OwnerLogin`: Owner authentication screen
  - `ManagerLogin`: Manager authentication screen

### `management.ui.sections`
- **Purpose**: Main dashboard and section navigation screens
- **Navigation Flow**:
  ```
  Factory → [Owner/Manager Login] → [Owner/Manager Section] → Work Details
                                                              → Employee Details
                                                              → Manager Details
                                                              → Production Details
                                                              → Sales Details
                                                              → Expenditure Details
  ```

### `management.ui.views`
- **Purpose**: Read-only data viewing screens with tables
- **Characteristics**:
  - Display data in JTable components
  - Read from database
  - Provide "Back" navigation

### `management.ui.forms`
- **Purpose**: Data entry and manipulation forms
- **Categories**:
  - **Add forms**: Create new records
  - **Delete forms**: Remove records
  - **Modify forms**: Update existing records
  - **Special**: MoneyDeposit for customer payments

## Application Flow

1. **Startup**: `Factory.java` (main entry point)
2. **Authentication**: User selects Owner or Manager login
3. **Dashboard**: User directed to appropriate section
4. **Operations**: Navigate to various management modules
5. **Actions**: Perform CRUD operations through forms
6. **Viewing**: Check data through view screens

## Database Schema Requirements

The application expects the following database setup:
- **Database Name**: `brick`
- **Tables**: 
  - `manager` - Manager accounts
  - `employee` - Employee records
  - `employeework` - Employee work logs
  - `costumer` - Customer records
  - `costumerrecord` - Customer transactions
  - `finalproduction` - Product catalog
  - `production` - Production records
  - `sales` - Sales transactions
  - `expenditure` - Expense records

See README.md for complete database schema.

## Dependencies

- Java 8 or higher
- MySQL 5.7 or higher
- MySQL Connector/J (JDBC driver)
- Java Swing (included in JDK)
- Java AWT (included in JDK)

## Design Patterns Used

1. **Separation of Concerns**: 
   - Database layer (database package)
   - Data access layer (dao package)
   - Presentation layer (ui package)

2. **Static Factory Methods**: DAO classes use static methods for operations

3. **Swing MVC**: Each UI class manages its own view components

