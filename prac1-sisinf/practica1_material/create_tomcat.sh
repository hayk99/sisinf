#!/bin/bash

PORTAL_PATH=$HOME/sisinf
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

# Creamos los directorios necesarios, si es preciso

if [ ! -d $PORTAL_PATH ]; then
    mkdir $PORTAL_PATH
    chmod 755 $PORTAL_PATH
fi

if [ ! -d $PORTAL_PATH/tomcat ]; then
    mkdir $PORTAL_PATH/tomcat
    chmod 777 $PORTAL_PATH/tomcat
fi

 
# Paramos y borramos la versión anterior del portal, si existe
docker stop sisinf-tomcat
docker rm sisinf-tomcat


# Copiamos los ficheros de configuración en la carpeta compartida
cp tomcat/context.xml $PORTAL_PATH/tomcat/tomcat/conf
cp tomcat/server.xml $PORTAL_PATH/tomcat/tomcat/conf
cp tomcat/tomcat-users.xml $PORTAL_PATH/tomcat/tomcat/conf
cp tomcat/*.war $PORTAL_PATH/tomcat/tomcat/data

# Creamos y arrancamos la imagen de tomcat
docker run -d --name sisinf-tomcat \
    -v $PORTAL_PATH/tomcat:/bitnami \
    -p 8080:8080 \
    bitnami/tomcat:latest

