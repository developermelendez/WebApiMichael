# Web API Project

This project is a web API implemented in Java using Spring Boot. It is Dockerized for easy deployment.

## Prerequisites

Make sure you have the following installed on your machine:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)
- Maven: [Install Maven](https://maven.apache.org/install.html)

## How to Run

1. Clone the repository:

    ```bash
    git clone https://github.com/developermelendez/web-api.git
    cd web-api
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Build the Docker image:

    ```bash
    docker-compose build
    ```

4. Run the Docker container:

    ```bash
    docker-compose up -d
    ```

   The `-d` flag runs the containers in the background.

5. Additional Docker Build and Run:

    After the services are up and running, you can perform additional steps to build a Docker image and run a container separately:

    ```bash
    docker build -t web-api .
    docker run -p 8081:8081 web-api
    ```

   This will build the Docker image named `web-api` and run a container, exposing port 8081.

6. Access Swagger UI:

    Open your web browser and go to [http://localhost:8081/swagger-ui/index.html#/](http://localhost:8081/swagger-ui/index.html#). Here, you can explore and test the API using Swagger.

## How to Stop

To stop the Docker containers, run:

```bash
docker-compose down
