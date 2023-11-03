#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

MAVEN_POM_FILE="kotlin-spring-boot-reactive/pom.xml"

# Build the Maven project
mvn clean install -f "$MAVEN_POM_FILE"

# Start the Spring Boot application and record its PID
mvn spring-boot:run -f "$MAVEN_POM_FILE"