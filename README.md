# Event Registration 

Spring Boot REST API for event management and user registrations with MongoDB.

## Tech Stack
- Java 21, Spring Boot, MongoDB, Maven

## Setup
```bash
git clone <repo-url>
cd event-registration
mvn spring-boot:run
```

Requires MongoDB running on localhost:27017

## API Endpoints

**Users:** `/users` - CRUD operations  
**Events:** `/events` - CRUD + `/events/upcoming`  
**Registrations:** `/registrations/{userId}/{eventId}` - Register/cancel  

## Sample Usage
```json
POST /users
{ "name": "John", "email": "john@example.com" }

POST /events  
{ "title": "Conference", "date": "2024-12-15T09:00:00" }

POST /registrations/{userId}/{eventId}
```

Server runs on `http://localhost:8080`
