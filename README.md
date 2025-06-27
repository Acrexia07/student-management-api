# Student Management API

A RESTful API for managing student records built with Spring Boot. This beginner-friendly project demonstrates CRUD operations, data validation, and proper API design patterns.

## 📋 Project Overview

The Student Management API allows administrators to create, read, update, and delete student data records. It's designed as a learning project to understand the fundamentals of building REST APIs with Spring Boot.

## ✨ Features

- **CREATE**: Add new student records to the system
- **READ**: Retrieve all students or find specific students by ID
- **UPDATE**: Modify existing student information
- **DELETE**: Remove student records from the database

## 🛠️ Tech Stack

- **Backend**: Java
- **Framework**: Spring Boot
- **Database**: H2DB, MySQL, Spring Data JPA
- **Tools**: Postman (for API testing)

## 📊 Data Model

### Student Entity
| Field | Type | Validation | Description |
|-------|------|------------|-------------|
| `id` | Long | Auto-generated | Unique student identifier |
| `name` | String | Not Blank, 2-100 characters | Student's full name |
| `gradeLevel` | String | Not Empty | FRESHMAN, SOPHOMORE, JUNIOR, or SENIOR |
| `contactNumber` | String | Not Empty | Valid Philippine mobile number |
| `email` | String | Not Blank, Valid email, Max 100 chars | Student's email address |
| `birthDate` | LocalDate | Not Empty | Student's date of birth |

### Validation Rules
- **Name**: Must be between 2 and 100 characters
- **Grade Level**: Must be one of the predefined values (FRESHMAN, SOPHOMORE, JUNIOR, SENIOR)
- **Contact Number**: Must be a valid Philippine mobile number format
- **Email**: Must be a valid email address with maximum 100 characters
- **Birth Date**: Must be a past date

## 🚀 API Endpoints

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| `GET` | `/api/students` | Retrieve all students |
| `GET` | `/api/students/{id}` | Retrieve student by ID |
| `POST` | `/api/students/{id}` | Create new student |
| `PUT` | `/api/students/{id}` | Update existing student |
| `DELETE` | `/api/students/{id}` | Delete student by ID |

## 📓 DTO MODEL PLAN

![image](https://github.com/user-attachments/assets/dfacd6ac-7dc0-48df-bf71-6310b63e474d)


## 📝 API Usage Examples

### Create Student (POST)
```json
{
  "name": "Juan Dela Cruz",
  "gradeLevel": "SOPHOMORE",
  "contactNumber": "09123456789",
  "email": "juan.delacruz@example.com",
  "birthDate": "2005-03-15"
}
```

### Read Student Response (GET)
```json
{
  "id": 1,
  "name": "Juan Dela Cruz",
  "gradeLevel": "SOPHOMORE",
  "contactNumber": "09123456789",
  "email": "juan.delacruz@example.com",
  "birthDate": "2005-03-15"
}
```

### Update Student (PUT)
```json
{
  "name": "Juan Miguel Dela Cruz",
  "gradeLevel": "JUNIOR",
  "contactNumber": "09123456789",
  "email": "juan.miguel@example.com",
  "birthDate": "2005-03-15"
}
```

## 🏗️ Project Architecture

The project follows a clean architecture pattern with clear separation of concerns:

```
CONTROLLER(DTO) ← → SERVICE (ENTITIES) ← → REPOSITORY (ENTITIES)
```

- **Controller Layer**: Handles HTTP requests and responses using DTOs
- **Service Layer**: Contains business logic and works with entities
- **Repository Layer**: Manages data persistence and database operations

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd student-management-api
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**
   - Base URL: `http://localhost:8080`
   - API endpoints: `http://localhost:8080/api/students`

### Database Configuration

The project is configured to work with MySQL. Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

For development, you can also use H2 in-memory database by adding H2 dependency.

## 🧪 Testing

The API has been manually tested using **Postman** to ensure all endpoints work correctly:

- ✅ Create new students with validation
- ✅ Retrieve all students
- ✅ Retrieve specific students by ID
- ✅ Update existing student information
- ✅ Delete students from the system
- ✅ Error handling for invalid data and missing resources

## 🎯 Learning Outcomes

This project helped me understand:

- **RESTful API Design**: Proper HTTP methods and status codes
- **Spring Boot Framework**: Configuration, annotations, and auto-configuration
- **Data Validation**: Using Bean Validation annotations
- **Database Integration**: JPA, Hibernate, and repository pattern
- **Error Handling**: Custom exception handling and validation responses
- **API Testing**: Manual testing with Postman
- **Project Planning**: Following a structured development approach

## 🔮 Future Enhancements

- [ ] Add authentication and authorization (JWT tokens)
- [ ] Implement pagination for student listings
- [ ] Add search and filtering capabilities
- [ ] Create automated unit and integration tests
- [ ] Add API documentation with Swagger/OpenAPI
- [ ] Implement caching for better performance
- [ ] Add logging and monitoring
- [ ] Database migration with Flyway/Liquibase
- [ ] Add different database profiles (dev, test, prod)
- [ ] Implement soft delete functionality

## 🤝 Contributing

This is a beginner learning project, but feedback and suggestions are welcome! Feel free to:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 📧 Contact

**Marlon Barnuevo** - marlzestien@gmail.com

Project Link: [https://github.com/Acrexia07/student-management-api](https://github.com/Acrexia07/student-management-api)

---
*This project was built as part of my journey learning Spring Boot and RESTful API development. It represents my understanding of fundamental backend development concepts and serves as a foundation for more complex projects.*
