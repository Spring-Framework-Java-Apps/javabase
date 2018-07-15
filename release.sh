#!/usr/bin/env bash


source conf.sh

./mvnw $DEFCON1_PROFILE_RELEASE clean install

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

echo "./mvnw clean release:prepare"

echo "./mvnw release:perform"

echo "git commit -m 'after release'"

echo "git push"

exit 0
