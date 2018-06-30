#!/bin/sh
gradle clean
gradle build

java -jar build/libs/fiap-on.jar
