
README.md: Campus Task Board API

Project Overview

This project is a Spring Boot REST API for managing tasks in a Campus Task Board system. It supports creating, updating, deleting, restoring, searching, and paginating tasks. The API was fully tested using Postman, and all endpoints return clean JSON responses.

The goal of this assignment was to practice building a complete backend with CRUD operations, soft delete functionality, and additional features like search and pagination.



Technologies Used

• Java 17

• Spring Boot

• Spring Web

• Spring Data JPA

• H2 Database (in‑memory)

• Maven

• Postman (for testing)




Project Structure

src/
└── main/
├── java/
│    └── com.example.taskboard
│          ├── controller
│          ├── service
│          ├── repository
│          └── model
└── resources/
├── application.properties
└── data.sql (optional)



How to Run the Project

1. Clone or download the project
2. Open in IntelliJ or VS Code
3. Run the Spring Boot application
4. API will start at:
   http://localhost:8081


API Endpoints

Below is a summary of all endpoints implemented and tested.



1. Create a Task

POST /api/tasks
Creates a new task with title, description, completion status, and priority.



2. Get All Tasks

GET /api/tasks
Returns a list of all non‑deleted tasks.



3. Get Task by ID

GET /api/tasks/{id}
Returns a single task by its ID.



4. Update a Task

PUT /api/tasks/{id}
Updates title, description, completion status, and priority.



5. Soft Delete a Task

DELETE /api/tasks/{id}
Marks a task as deleted without removing it from the database.



6. Restore a Task

PUT /api/tasks/{id}/restore
Restores a previously soft‑deleted task.



7. Search Tasks

GET /api/tasks/search?keyword=...
Searches tasks by title or description.



8. Pagination (Completed Tasks)

GET /api/tasks/completed?page=0&size=5
Returns completed tasks with pagination metadata.


Screenshots

All 10 screenshots of the API tests (POST, GET, PUT, DELETE, RESTORE, SEARCH, PAGINATION) are included in the final PDF submission.



Summary

This project demonstrates:

• Full CRUD functionality

• Soft delete + restore

• Search filtering

• Pagination

• Clean JSON responses

• Organized backend structure

• Successful Postman testing


Everything works as expected, and all endpoints return correct status codes.


