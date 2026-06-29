# Employee Management System using Hibernate

A simple Java console-based application developed using Hibernate ORM and MySQL that performs CRUD operations on employee records. 
This project demonstrates important Hibernate concepts such as Component Mapping, Inheritance Mapping, and Association Mapping.

## Features

- Add Permanent Employee
- Add Contract Employee
- View All Employees
- Update Employee Salary
- Delete Employee
- Menu-driven console application

## Hibernate Concepts Used

- CRUD Operations
- Component Mapping (`@Embedded`)
- Inheritance Mapping (`@Inheritance`)
- Association Mapping (`@ManyToOne`, `@OneToMany`)
- Session and Transaction Management
- Hibernate Configuration using `hibernate.cfg.xml`

## Technologies Used

- Java 11
- Hibernate ORM
- MySQL 8
- Maven
- Eclipse IDE
- Git & GitHub

## Project Structure

```
EmployeeManagementSystem/

├── src/main/java
│   ├── com.pojo
│   │   ├── Address.java
│   │   ├── Employee.java
│   │   ├── PermanentEmp.java
│   │   ├── ContractEmp.java
│   │   └── Department.java
│   │
│   ├── com.service
│   │   └── EmployeeService.java
│   │
│   ├── com.test
│   │   └── TestEmployee.java
│   │
│   └── com.util
│       └── HibernateUtil.java
│
├── src/main/resources
│   └── hibernate.cfg.xml
│
├── pom.xml
└── README.md
```

## Database

Create a database in MySQL:

```sql
CREATE DATABASE employee_db;
```

Hibernate will automatically create the required tables when the application is executed.

## Entity Relationships

### Employee
- Employee ID
- Name
- Salary
- Address (Embedded)
- Department

### Permanent Employee
- Bonus

### Contract Employee
- Contract Duration (Months)

### Department
- Department ID
- Department Name
- List of Employees

## Hibernate Mapping Used

| Mapping | Description |
|---------|-------------|
| Component Mapping | Employee contains an embedded Address object using `@Embedded`. |
| Inheritance Mapping | Employee is the parent class of PermanentEmp and ContractEmp using `JOINED` strategy. |
| Association Mapping | Many Employees belong to one Department using `@ManyToOne` and `@OneToMany`. |

## How to Run

1. Clone the repository.

```
git clone https://github.com/your-username/Employee-Management-System-Hibernate.git
```

2. Open the project in Eclipse.

3. Configure MySQL in `hibernate.cfg.xml`.

```xml
hibernate.connection.url=jdbc:mysql://localhost:3306/employee_db
hibernate.connection.username=root
hibernate.connection.password=your_password
```

4. Update Maven dependencies.

```
Right Click Project
→ Maven
→ Update Project
```

5. Run `TestEmployee.java`.

## Sample Menu

```
========== Employee Management System ==========
1. Add Permanent Employee
2. Add Contract Employee
3. View Employees
4. Update Salary
5. Delete Employee
6. Exit
```

## Future Enhancements

- Search Employee by ID
- Search Employee by Name
- Delete Department
- Update Department
- Add Validation
- Logging using Log4j
- Spring Boot Integration

## Author

**Aishwarya Khadilkar**
