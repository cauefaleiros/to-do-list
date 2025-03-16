# 📋 Simple To-Do List API

A lightweight and efficient To-Do List API built with Java, Spring Boot, and PostgreSQL, providing full CRUD functionality for task management.
This project was developed with the purpose of learning and understanding more about backend development with Spring.

## 🚀 How to Run the Project

### Prerequisites
- Java 17+
- Maven
- PostgreSQL installed and running

### 📂 Clone the repository
```bash
git clone https://github.com/cauefaleiros/todo-list.git
cd todo-list
```

### 🔧 Database Configuration
1. Create a database in PostgreSQL
2. Update the credentials in `application.properties` or `application.yml`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/to-do-list
spring.datasource.username=postgres
spring.datasource.password=admin
```

### 🛠️ Install dependencies and run the project
```bash
./mvnw spring-boot:run
```

### ✅ Access the API
The API will be running at: [http://localhost:8080](http://localhost:8080)

## 📝 How to Create a Task

Using Postman or any other API client, send a `POST` request to the endpoint:
```http
POST http://localhost:8080/api/tasks
```

### 📄 Request Body (JSON):
```json
{
    "title": "My first task :)",
    "description": "descriptions can be null, but this one will not be >:)"
}
```

### ✅ Response Example:
```json
{
    "id": 1,
    "title": "My first task :)",
    "description": "descriptions can be null, but this one will not be >:)"
    "createdAt": "2025-03-16T10:30:00Z"
}
```

## 📖 API Documentation

Swagger UI is available for detailed API documentation and testing. Access it via:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📝 To-Do
- [ ] Implement user authentication
- [ ] Add task due dates
- [ ] Integrate a front-end interface
- [ ] Improve error handling
- [ ] Write unit and integration tests
