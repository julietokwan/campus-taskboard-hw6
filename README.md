Campus Task Board API (HW6)
A Spring Boot REST API for managing tasks with full CRUD operations, filtering, searching, and pagination.
Developed for CISC 3130 – Homework 6.


Overview
This project implements a Task Board system where users can:


Create tasks


View all tasks


Update tasks


Delete tasks


Filter tasks by completion status


Filter tasks by priority


Search tasks by keyword


Retrieve tasks with pagination


All endpoints were fully tested using Postman.


Technologies Used
Java 17


Spring Boot


Spring Web


Spring Data JPA


H2 Database


Maven


Postman (for API testing)


How to Run the Project
1. Requirements
   Java 17 installed


Maven installed (optional — IntelliJ handles it automatically)


2. Running the Application
   Open the project in IntelliJ


Run the main class:


Code
CampusTaskboardApplication.java
When the server starts, you should see:


Code
Tomcat started on port(s): 8081
Started CampusTaskboardApplication
API base URL:


Code
http://localhost:8081/api/tasks
Endpoints
CRUD Endpoints
Method	Endpoint	Description
POST	/api/tasks	Create a new task
GET	/api/tasks	Get all tasks
GET	/api/tasks/{id}	Get a task by ID
PUT	/api/tasks/{id}	Update a task
DELETE	/api/tasks/{id}	Delete a task




Special Endpoints (HW6 Requirements)
Method	Endpoint	Description
GET	/api/tasks/completed	Get all completed tasks
GET	/api/tasks/incomplete	Get all incomplete tasks
GET	/api/tasks/priority/{priority}	Filter by LOW, MEDIUM, HIGH
GET	/api/tasks/search?keyword=	Search by title or description
GET	/api/tasks/paginated?page=&size=	Pagination support




Example JSON (Create Task)
json
{
"title": "Buy groceries",
"description": "Milk, eggs, bread",
"completed": false,
"priority": "LOW"
}

 Postman Testing

All endpoints were tested successfully in Postman, including:


Creating tasks


Updating tasks


Filtering (completed/incomplete/priority)


Searching


Pagination