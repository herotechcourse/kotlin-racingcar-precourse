# Stage 1: Build the application
FROM gradle:8.7.0-jdk-jammy AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle.kts settings.gradle gradle.properties ./
COPY gradle gradle

# Copy the source code
COPY src ./src

# Build the application
RUN gradle --no-daemon --info clean build

# Stage 2: Run the application
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
