#!/bin/sh

# Exits immediately if a command exits with a non-zero status
set -e

sh kotlin-spring-boot/down.sh; sh kotlin-spring-boot/up.sh
