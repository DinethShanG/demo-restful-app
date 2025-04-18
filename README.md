# Student Management API

A RESTful API for managing student records built with Spring Boot, JPA, and PostgreSQL.

## Features

- Create, read, update, and delete student records
- Input validation with Jakarta Validation
- Exception handling
- RESTful API endpoints
- Containerized with Docker and Docker Compose
- Database migrations with Flyway

## Technologies

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Gradle
- Flyway for database migrations
- Lombok for reducing boilerplate code
- HikariCP for connection pooling

## Getting Started

### Prerequisites

- Java 17 or higher
- Docker and Docker Compose
- Gradle

### Running Locally

1. Clone the repository
2. Navigate to the project directory
3. Build the application:
   ```bash
   ./gradlew build
   ```
4. Run the application using Docker Compose:
   ```bash
   docker-compose up
   ```

The API will be available at http://localhost:8080/api/v1/students

## API Endpoints

| Method | URL                       | Description               |
|--------|---------------------------|---------------------------|
| GET    | /api/v1/students          | Get all students          |
| GET    | /api/v1/students/{id}     | Get student by ID         |
| POST   | /api/v1/students          | Create a new student      |
| PUT    | /api/v1/students/{id}     | Update an existing student|
| DELETE | /api/v1/students/{id}     | Delete a student          |
