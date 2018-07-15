#!/usr/bin/env bash

source conf.sh

../mvnw $DEFCON1_PROFILE_BUILD_JAR clean install

# TODO: $DEFCON1_PROFILE_RUN_JAR_LIKE_HEROKU

java -Dserver.port=$PORT $JAVA_OPTS -jar target/kandidaten-2.0.1-SNAPSHOT.jar
