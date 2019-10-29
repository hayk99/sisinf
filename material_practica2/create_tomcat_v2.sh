#!/bin/bash

# Paramos y borramos la versión anterior del portal, si existe
docker stop sisinf-tomcat
docker rm sisinf-tomcat

cd tomcat
sudo docker build -t sisinf/tomcat:latest .

docker run -d --name sisinf-tomcat \
    --link sisinf-mariadb \
    -p 8080:8080 \
    sisinf/tomcat:latest



