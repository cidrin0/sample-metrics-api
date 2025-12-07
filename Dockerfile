# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.4-alpine3.18

# Set the working directory in the container
WORKDIR /sample-metrics-api

# Copy the JAR file into the container
COPY ./build/libs/sample-metrics-api-0.0.1-SNAPSHOT.jar metrics-api.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "metrics-api.jar"]