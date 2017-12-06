#!/bin/bash

declare args="-Dspring.rabbitmq.reciver=true -Dscheduler.enabled=false ${1}"
declare file="target/marketplace-poc-rabbitmq-1.0-SNAPSHOT.jar"

java ${args} -jar ${file}
