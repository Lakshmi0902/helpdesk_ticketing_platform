# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/helpdesk.jar app.jar

# Expose port (must match Spring Boot port)
EXPOSE 9090

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
