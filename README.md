# Helpdesk Ticketing System

# Overview
This project is a scalable, enterprise-grade backend support ticketing system, designed using Java 17+ and Spring Boot 3+.
It provides RESTful APIs for ticket management, real-time collaboration, event logging, and messaging between collaborators.
The architecture follows clean code principles, domain-driven design (DDD), and ensures stateless, secure, and extensible APIs.

# Tech Stack
 * Java 17+
 * Spring Boot 3+
 * Spring Data JPA
 * PostgreSQL 
 * Lombok (boilerplate reduction)
 * MapStruct (DTO ↔ Entity mapping)
 * Swagger / OpenAPI (API documentation)
 * Maven (build tool)

# Configuration
application.properties
  spring.application.name=Helpdesk
  server.port=9090
  spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
  spring.datasource.username=postgres
  spring.datasource.password=root
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.jpa.properties.hibernate.default_schema=helpdesk
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
  
  # Swagger
  springdoc.api-docs.enabled=true
  springdoc.swagger-ui.enabled=true

# Data Modeling
 Enums
 EventType → TICKET_CREATE, TICKET_UPDATE, STATUS_CHANGE, ASSIGNEE_CHANGE, MESSAGE_NEW
 TicketStatus → OPEN, IN_PROGRESS, RESOLVED, CLOSED

# API Endpoints
Ticket Management (/api/tickets)
  POST /api/tickets → Create new ticket
  PUT /api/tickets/{id} → Update ticket
  DELETE /api/tickets/{id} → Delete ticket
  GET /api/tickets → List all tickets
  GET /api/tickets/{id} → Get ticket by ID
  POST /api/tickets/{id}/messages?sender=xyz → Send a message in a ticket
  GET /api/tickets/tickets/{ticketId}/details → Fetch ticket with messages

Collaborators (/api/collaborators)
  POST /api/collaborators → Add collaborator to a ticket
  GET /api/collaborators/ticket/{ticketId} → Get collaborators for a ticket

Messages (/api/messages)
  GET /api/messages/ticket/{ticketId} → Get messages for a ticket

Events (/api/events)
  POST /api/events → Log a ticket event
  GET /api/events/ticket/{ticketId} → Get events for a ticket

# API Documentation (Swagger UI)
Once the application is running, access Swagger UI:
  http://localhost:9090/swagger-ui.html
