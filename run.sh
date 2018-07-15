#!/usr/bin/env bash

source defcon-parent/conf.sh

export MVN_CMD='./mvnw'

#mvn_fast_build
#mvn_build
mvn_site
#mvn_travis
#mvn_heruko
#mvn_run

exit 0
