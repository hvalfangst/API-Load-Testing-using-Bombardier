#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

# Remove prayer DB container
docker-compose -f kotlin-spring-boot/db/prayer/docker-compose.yml down