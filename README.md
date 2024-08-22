
### Root README (`README.md`)

```markdown
# Courses Application

## Overview
This repository contains the full stack application for managing courses and their delivery instances. It includes a backend REST API developed in Java Spring Boot and a frontend interface developed in React.

## Repository Structure
- `backend/` - Contains the backend application with API endpoints.
- `frontend/` - Contains the frontend application for interacting with the API.
- `docker-compose.yaml` - Docker Compose configuration for running both frontend and backend together.

## Setup Instructions

### Running Locally
1. Build and run the backend:
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run

   Docker:
   cd backend
   docker build -t rakeshvanam1/backend-image:latest .
   docker push rakeshvanam1/backend-image:latest


2. Build and run the Frontend:
    cd frontend
    npm install
    npm start
    
    Docker:
    cd frontend
    docker build -t rakeshvanam1/frontend-image:latest .
    docker push rakeshvanam1/frontend-image:latest
