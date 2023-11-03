#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

docker-compose -f "db/prayers/docker-compose.yml" down;
docker-compose -f "db/prayers/docker-compose.yml" up -d;

sh kotlin-spring-boot-mvc/build_and_run.sh &

sleep 10

bombardier -m POST http://localhost:8080/prayers -c 1000 -n 2500 -H "Content-Type: application/json" -f "payload.json";

docker-compose -f "db/prayers/docker-compose.yml" down;
docker-compose -f "db/prayers/docker-compose.yml" up -d;

sh kotlin-spring-boot-reactive/build_and_run.sh &

sleep 10

bombardier -m POST http://localhost:8081/prayers -c 1000 -n 2500 -H "Content-Type: application/json" -f "payload.json";

wait
