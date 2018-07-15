#!/usr/bin/env bash

source defcon-parent/conf.sh

export MVN_CMD='./mvnw'

#mvn_fast_build
mvn_build

exit 0
