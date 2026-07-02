# MediumTracker

A REST backend for managing different types of media such as games, movies, and additional media types in the future.

This project is built with **Java**, **Spring Boot**, and **Maven** as a learning and portfolio project to explore modern backend development.

---

## Technologies

* Java 21 (LTS)
* Spring Boot 3.5.x
* Maven
* Spring Web
* Spring Data JPA
* REST API
* Lombok
* YAML configuration (`application.yml`)

---

## Getting Started

Clone the repository:

```bash
git clone git@github.com:Bugi-Shi/mediumtracker.git
cd mediumtracker
```

Start the application:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw spring-boot:run
```

The API will then be available at:

```
http://localhost:8080
```

---

## Available Endpoints

| Endpoint | Description           |
| -------- | --------------------- |
| `/`      | Overview of all media |
| `/game`  | Game API              |
| `/movie` | Movie API             |

---

## Maven Commands

Useful Maven commands:

```bash
mvn compile   # Compile the source code
mvn test      # Run tests
mvn package   # Build the JAR file
mvn clean     # Remove build artifacts
```

---

## Project Status

🚧 This project is currently under active development.

### Planned Features

* [x] Basic Spring Boot project structure
* [x] Entity inheritance using `Medium`
* [x] Movie entity
* [ ] Extend the Game entity
* [ ] Database integration
* [ ] CRUD REST API
* [ ] DTOs
* [ ] Service layer
* [ ] Global exception handling
* [ ] Unit and integration tests
* [ ] Swagger / OpenAPI documentation
* [ ] AuthenticatiWon & Authorization
