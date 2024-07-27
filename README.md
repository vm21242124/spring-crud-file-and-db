Here’s a `README.md` file for running your Docker image from Docker Hub:

```markdown
# Spring Boot CRUD Application

This project provides a Docker image for a Spring Boot CRUD application. This image has been published to Docker Hub and can be easily pulled and run.

## Pulling the Docker Image

To pull the Docker image from Docker Hub, use the following command:

```bash
docker pull vm2124/crud-app:latest
```

## Running the Docker Image

To run the Docker container for this Spring Boot application, use the following command:

```bash
docker run -d \
  --name crud-app \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/vinod \
  -e SPRING_DATASOURCE_USERNAME=vinod \
  -e SPRING_DATASOURCE_PASSWORD=vinod \
  vm2124/crud-app:latest
```

### Environment Variables

- `SPRING_DATASOURCE_URL`: JDBC URL for connecting to the MySQL database.
- `SPRING_DATASOURCE_USERNAME`: Database username.
- `SPRING_DATASOURCE_PASSWORD`: Database password.

Replace these values as necessary for your environment.

## Running with Docker Compose

If you want to run the application along with a MySQL database, you can use Docker Compose. Here's a sample `docker-compose.yml` file:

```yaml
version: '3.8'

services:
  mysql:
    image: mysql
    container_name: mysql-container
    environment:
      MYSQL_ROOT_PASSWORD: root_password
      MYSQL_DATABASE: vinod
      MYSQL_USER: vinod
      MYSQL_PASSWORD: vinod
    ports:
      - "3306:3306"

  springboot-app:
    image: vm2124/crud-app:latest
    container_name: springboot-app
    ports:
      - "8080:8080"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/vinod
      SPRING_DATASOURCE_USERNAME: vinod
      SPRING_DATASOURCE_PASSWORD: vinod
```

To start the services, use:

```bash
docker-compose up
```

This command will start both the MySQL database and the Spring Boot application.

## Stopping and Removing Containers

To stop and remove the containers created by Docker Compose, use:

```bash
docker-compose down
```

Or, if you started the container manually:

```bash
docker stop crud-app
docker rm crud-app
```

## Accessing the Application

Once the container is running, you can access the Spring Boot And swagger apis application at:

```plaintext
http://localhost:8080/swagger-ui/index.html
```

## Troubleshooting

If you encounter issues, check the logs for more information:

```bash
docker logs crud-app
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or issues, please contact [Your Name] at [Your Email Address].

```

### Summary

- **Pull** the Docker image from Docker Hub.
- **Run** the Docker container with environment variables.
- **Use Docker Compose** for running both the Spring Boot application and MySQL.
- **Stop and Remove** containers as needed.
- **Access** the application at `http://localhost:8080`.

Replace placeholders like `[Your Name]` and `[Your Email Address]` with your actual contact details. This `README.md` provides clear instructions for users to pull and run your Docker image effectively.