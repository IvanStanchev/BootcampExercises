# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory to /app
WORKDIR /app

# Copy the target folder to the container
COPY out/artifacts/springSecurityTutorial_jar/springSecurityTutorial.jar app.jar

# Set the environment variable for the Spring profile
ENV SPRING_PROFILES_ACTIVE=prod

# Expose port 5001 for the Spring Boot application
EXPOSE 8080

# Run the Spring Boot application with host network
CMD ["java", "-jar", "app.jar"]
