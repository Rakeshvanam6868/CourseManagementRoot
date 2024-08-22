# Use the official OpenJDK image.
FROM openjdk:17-jdk

# Set the working directory in the container.
WORKDIR /app

# Copy the JAR file into the container.
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on.
EXPOSE 8080

# Run the application.
ENTRYPOINT ["java", "-jar", "app.jar"]
