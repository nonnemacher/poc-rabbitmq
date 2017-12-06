#!/bin/bash

declare args="-Dspring.rabbitmq.reciver=false -Dscheduler.enabled=true ${1}"
declare file="target/marketplace-poc-rabbitmq-1.0-SNAPSHOT.jar"

java ${args} -jar ${file}
