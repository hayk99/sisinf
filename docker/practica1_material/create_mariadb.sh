#!/bin/bash

PORTAL_PATH=$HOME/sisinf
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

if [ ! -d $PORTAL_PATH ]; then
    mkdir $PORTAL_PATH
    chmod 755 $PORTAL_PATH
fi

if [ ! -d $PORTAL_PATH/mysql ]; then
    mkdir $PORTAL_PATH/mysql
    chmod 777 $PORTAL_PATH/mysql
fi
 
docker stop sisinf-mariadb
docker rm sisinf-mariadb

docker run -d --name sisinf-mariadb \
    -e MARIADB_ROOT_PASSWORD=sisinf \
    -e MARIADB_DATABASE=sisinf  \
    -v $PORTAL_PATH/mysql:/bitnami/mariadb \
    -p 3306:3306 \
    bitnami/mariadb:latest

    

