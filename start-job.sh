#!/usr/bin/env sh
pm2 delete room-status

git checkout master
git pull

gradle clean
gradle build

cd build/libs

pm2 start java --name="room-status" -- -jar room-status-service-0.0.1-SNAPSHOT.jar sever config.yml