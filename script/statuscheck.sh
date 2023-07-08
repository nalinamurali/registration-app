#!/bin/bash


getAppHealth() {

  curl \

    -o /dev/null \

    --silent \

    --head \

    --write-out '%{http_code}' \

    "http://localhost:8080/registration/actuator/health"

}



status=$(getAppHealth)          # initialize to actual value before we sleep even once

if [ "$status" = 200 ]

 then

  echo $(date -u)" - Application is UP"

else

  echo $(date -u)" - Application is down"

fi