# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the image
WORKDIR /app

# Copy necessary files for building the application
COPY ./target/web-api-0.0.1-SNAPSHOT.jar /app/web-api.jar

# Expose the port on which the application will run
EXPOSE 8081

# Command to run the application when the container starts
CMD ["java", "-jar", "web-api.jar"]