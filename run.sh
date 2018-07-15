#!/usr/bin/env bash

source conf.sh

export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'

./mvnw clean spring-boot:run

exit 0
