#!/bin/bash
echo "sdk.dir=$ANDROID_HOME" > local.properties
./gradlew clean
./gradlew assembleRelease