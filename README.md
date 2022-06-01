# unicomer
API para capturar los datos de candidatos de posibles clientes para Unicomer Jamaica.

# Pre-requisitos

Tener instalado GIT
Tener instalado maven
Java 8 en adelante.
MySql

Pasoss para ejecucion de la API.

# 1 Clonar repo

git clone https://github.com/hhidalgo90/unicomer.git

# 2 Compilar proyecto

Entrar por linea de comando al directorio donde se encuentra el proyecto.
Ejecutar : mvn package

# 3 Ejecutar proyecto

cd /target
java -jar tienda-0.0.1-SNAPSHOT.jar

El proyecto se ejecuta en el browser: localhost:8081/tienda

# IMPORTANTE

La app esta configurada para correr en el perfil "local", utilizando la base de datos H2, en caso de querer usar mySql 
ejecuctar el siguiente comando en el paso 3:

java -jar tienda-0.0.1-SNAPSHOT.jar --spring.profiles.active=default