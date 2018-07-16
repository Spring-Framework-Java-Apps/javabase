#!/usr/bin/env bash

source defcon-parent/conf.sh

export MVN_CMD='./mvnw'

function current_int(){
    echo "current_int"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    #mvn_build
    mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}


function current_prod(){
    echo "current_prod"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    #mvn_build
    mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}

function current_test_smoketest(){
    echo "current_test_smoketest"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    mvn_build
    #mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}

function current_test_regression(){
    echo "current_test_regression"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    #mvn_build
    #mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}

function current_test_pre_release(){
    echo "current_test_pre_release"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    #mvn_build
    #mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}


function current_test_bug_seach_and_fix(){
    echo "current_test_bug_seach_and_fix"
    #mvn_jbake_help
    #run_jbake_seed
    #mvn_jbake

    #mvn_fast_build
    #mvn_build
    #mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}

function current_test(){
    echo "current_test"
    current_test_smoketest
    current_test_regression
    current_test_pre_release
    current_test_bug_seach_and_fix
}

function current_dev(){
    echo "current_dev"
    #mvn_jbake_help
    run_jbake_seed
    #mvn_jbake

    #mvn_validate
    #mvn_fast_build
    #mvn_build
    #mvn_site
    #mvn_travis
    #mvn_heruko
    #mvn_run
}


function run(){
    echo "run"
    current_dev
    #current_int
    #current_prod
    #current_test
}

run

exit 0
