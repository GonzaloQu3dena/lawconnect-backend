# LawConnect Backend

## Summary
<p align="justify">
LawConnect Backend is a monolithic platform developed in Java 17 with Spring Boot, following Domain-Driven Design (DDD) principles. It provides a RESTful API to connect lawyers and clients for managing legal cases. The application uses Spring Data JPA for persistence in MySQL, Spring Security with JWT for authorization, and is fully documented with OpenAPI and Swagger UI.
</p>

## Features ✨
- **RESTful API** organized into Bounded Contexts according to DDD
- **OpenAPI Documentation** integrated with Swagger UI
- **Security and Authentication** using Spring Security and JSON Web Tokens (JWT)
- **Password Hashing** using `HashingService`
- **Validation** of requests with Spring Validation (`@Valid`)
- **Persistence** with Spring Data JPA and MySQL
- **Automatic Auditing** of entities (`createdAt`, `updatedAt` fields)
- **Naming Strategy** for tables in snake_case and pluralized
- **Environment Variable Configuration** via `.env` with `spring-dotenv`
- **Domain Events** and internal notifications via `ApplicationEventPublisher`

## Bounded Contexts 🗂️
<p align="justify">
The platform is divided into four Bounded Contexts, each with its own domain layer, services, and repositories. They communicate with each other through Anti-Corruption Layers (ACL) or domain events.
</p>

### 1. Identity & Access Management (IAM)
Responsible for security, users, and roles.
- User Sign-Up (assign role: ADMIN, LAWYER, CLIENT)
- User Sign-In and JWT issuance
- Endpoints to retrieve users and roles
- Authorization filter in the Spring Security pipeline
- Automatic seeding of roles at application startup

### 2. Profiles
Management of lawyer and client profiles.
- CRUD for **ClientProfile** and **LawyerProfile**
- Seeding of legal specialties (`LawyerSpecialties`)
- Profile searches by ID number and specialty
- REST resources with assemblers (`Assembler`)

### 3. Cases
Core platform for managing legal cases.
- **Case Creation** by clients
- **Invitations** for lawyers to join cases
- **Applications** by lawyers to open cases
- **Acceptance/Rejection** of invitations and applications
- **Case States**: Open → Evaluation → Accepted → Closed/Canceled
- **Comments** (general and final) with workflow validation
- **Queries**: cases by client, lawyer, status, timeline, comments, and invitations

### 4. Shared Infrastructure
Common layer across all contexts.
- Auditable base classes (`AuditableAbstractAggregateRoot`, `AuditableModel`)
- OpenAPI configuration (`OpenApiConfiguration`)
- Hibernate naming strategy (`SnakeCaseWithPluralizedTablePhysicalNamingStrategy`)
- Generic resources (`MessageResource`)

## `.env` File Configuration ⚙
To facilitate local and environment setup, the project uses the [spring-dotenv](https://github.com/paulschwarz/spring-dotenv) plugin. Create a `.env` file at the project root with the following variables:

```dotenv
# MySQL service port (default 3306)
DB_PORT=3306

# Password for MySQL root user
MYSQL_ROOT_PASSWORD=YourMySQLPassword

# Secret key for signing JWT (keep secure)
JWT_SECRET=YourJWTSecret

# (Optional) Application port for Spring Boot
# SERVER_PORT=8080
```

> **How to use**
> 1. Install and configure MySQL at `localhost:DB_PORT`.
> 2. Create the `lawconnect-db` database and grant privileges to the `root` user.
> 3. On application startup, `spring-dotenv` will load the variables from `.env`.
> 4. Spring Boot will resolve properties in `application.properties`, e.g.:

>    ```properties
>    spring.datasource.url=jdbc:mysql://localhost:${DB_PORT}/lawconnect-db?useSSL=false&serverTimezone=UTC
>    spring.datasource.password=${MYSQL_ROOT_PASSWORD}
>    authorization.jwt.secret=${JWT_SECRET}
>    ```  
> 5. Run the application with Maven or your preferred IDE.

