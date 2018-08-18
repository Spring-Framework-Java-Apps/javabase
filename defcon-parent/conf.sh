#!/usr/bin/env bash

# TODO: add issue: remove this from git repo
export DEFCON1_LOGIN_USERNAME=nbc
export DEFCON1_LOGIN_PASSWORD=natural-born-coder
export DEFCON1_GOOGLE_APS_API_KEY=AIzaSyCMWLD6SK1QY3f-94mDS6x7u_jxwYASgqY
export DEFCON1_GOOGLE_ANALYTICS_ID=UA-17174370-11
export DEFCON1_GOOGLE_WEBMASTER_TOOLS_ID=3eksTC3Rvao6fLvSUwoRECBwd9Gdg4F51IhOE3DD-T8
export DEFCON1_MICROSOFT_WEBMASTER_TOOLS_ID=52F1EDC0244BCDCF5C95E402E9E3E49B
export DEFCON1_FACEBOOK_APP_ID=1721279777913278
export DEFCON1_TWITTER_CARD_SITE=port80guru
export DEFCON1_TWITTER_CARD_CREATOR=port80guru

export DEFCON1_PROFILE_DEFAULT='-Pdefault'
export DEFCON1_PROFILE_DEV_embedded='-Pdevembedded'
export DEFCON1_PROFILE_INT_embedded='-Pintembedded'
export DEFCON1_PROFILE_TEST_embedded='-Ptestembedded'
export DEFCON1_PROFILE_PROD_embedded='-Pprodembedded'
export DEFCON1_PROFILE_TRAVIS_embedded='-Ptravisembedded'
export DEFCON1_PROFILE_DEV='-Pdev'
export DEFCON1_PROFILE_INT='-Pint'
export DEFCON1_PROFILE_TEST='-Ptest'
export DEFCON1_PROFILE_PROD='-Pprod'
export DEFCON1_PROFILE_TRAVIS='-Ptravis'

export DEFCON1_PROFILE_RUN=$DEFCON1_PROFILE_DEFAULT
export DEFCON1_PROFILE_RELEASE=$DEFCON1_PROFILE_TEST_embedded
export DEFCON1_PROFILE_BUILD_JAR=$DEFCON1_PROFILE_DEFAULT

# TODO: add issue
export DEFCON1_PROFILE_RUN_JAR_LIKE_HEROKU=''

export MAVEN_OPTS="-Xmx2048m"
export PORT=8080
#export JAVA_OPTS='-Xmx350m -Xss512k'

export JAVA_OPTIONS='-Xmx2048m -Xss4096k -Dfile.encoding=UTF-8'

# Overwrite this in the submodules run.sh files for correct relative path
export MVN_CMD='../mvnw'
export MVN_CMD_CLOUD_APPS='../mvnw'

#TODO: #48
function mvn_validate(){
    $MVN_CMD clean validate
}

#TODO: #47
function mvn_fast_build(){
    $MVN_CMD clean install
}

#TODO: #46
function mvn_build(){
    $MVN_CMD clean install dependency:tree
}

#TODO: #45
function mvn_run(){
    $MVN_CMD $DEFCON1_PROFILE_RUN clean spring-boot:run
}

#TODO: #44
function mvn_heruko(){
    export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'
    $MVN_CMD $DEFCON1_PROFILE_RUN clean spring-boot:run
}

function mvn_jbake_help(){
    $MVN_CMD jbake:help -Ddetail -DgoalName=seed
}

function run_jbake_seed(){
    $MVN_CMD jbake:seed
}

function mvn_jbake_run(){
    $MVN_CMD clean jbake:generate jbake:inline
}

function mvn_jbake(){
    $MVN_CMD clean jbake:generate
}

#TODO: #42
function mvn_site2(){
    HERE=`pwd`
    #cd defcon-applications/defcon-cloud-apps/
    cd defcon-applications
    $MVN_CMD_CLOUD_APPS -e -X clean site site:deploy
    cd $HERE
}
#TODO: #42, #49
function mvn_site(){
    #HERE=`pwd`
    #cd defcon-applications/defcon-cloud-apps/
    #cd defcon-applications
    $MVN_CMD -e clean site site:deploy
    #cd $HERE
}

function mvn_site_run(){
    $MVN_CMD clean site site:run
}

#TODO: #43
function mvn_travis(){
    $MVN_CMD clean install jbake:generate site site:deploy -Ptravis -Dtest=AlphaTopLevelSuiteIT  -B -V
}
