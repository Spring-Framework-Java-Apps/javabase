#!/usr/bin/env bash

source conf.sh

export MAVEN_OPTS="-Xmx512m"

./mvnw -e clean install dependency:tree site

exit 0
