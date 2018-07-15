#!/usr/bin/env bash

source conf.sh

./mvnw -e clean install dependency:tree site

exit 0
