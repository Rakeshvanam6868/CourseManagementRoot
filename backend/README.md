# Courses API Backend

## Overview
This project is a REST API backend developed using Java Spring Boot that provides endpoints for managing courses and their delivery instances.

## Features
- Create, read, update, and delete courses
- Create, read, update, and delete course instances

## API Endpoints

### Courses
- `POST /api/courses` - Create a new course
- `GET /api/courses` - List all courses
- `GET /api/courses/{id}` - View details of a course
- `DELETE /api/courses/{id}` - Delete a course

### Course Instances
- `POST /api/instances` - Create a new instance of a course
- `GET /api/instances/{year}/{semester}` - List course instances by year and semester
- `GET /api/instances/{year}/{semester}/{id}` - View details of a course instance
- `DELETE /api/instances/{year}/{semester}/{id}` - Delete a course instance

## Setup Instructions

### Prerequisites
- JDK 17
- Maven

### Running Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/Rakeshvanam6868/CourseManagementBackend.git
2. cd backend
3. mvn clean install
4. mvn spring-boot:run



