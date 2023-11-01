#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

ROOT_FOLDER="kotlin-spring-boot"
DOCKER_COMPOSE="$ROOT_FOLDER/db/prayer/docker-compose.yml"

# Create prayer DB container
docker-compose -f "$DOCKER_COMPOSE" up -d

MAVEN_POM_FILE="$ROOT_FOLDER/pom.xml"

# Build the Maven project
echo "Running 'mvn clean install'..."
mvn clean install -f "$MAVEN_POM_FILE"

# Start the Spring Boot application
echo "Starting the Spring Boot app..."
mvn spring-boot:run -f "$MAVEN_POM_FILE"

