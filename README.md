Approach:
Architecture:

I followed a layered architecture pattern with distinct layers for models, repositories, services, and controllers.
The application uses Spring Boot to simplify the creation and management of RESTful services, ensuring a clean separation of concerns.
User Registration and Authentication:

Implemented user registration with username and password

Task Management:

Tasks are associated with users, and the application supports CRUD operations.
Filters for tasks based on status, priority, and due date are implemented using repository query methods.

Dockerization:

The application is containerized using Docker, allowing it to be easily deployed and run in any environment. Docker Compose is used to manage the application and its dependencies (e.g., PostgreSQL).

Users:

Each user can manage their own tasks but cannot access tasks assigned to other users.
Task Fields:

Fields like status, priority, and due date are assumed to be sufficient for managing task states.

Database:

MYSQL is used as the database, and it is assumed that the environment supports Docker.
Performance and Scalability:

While basic filters and pagination are implemented.
