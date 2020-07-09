# challange
This app provide a REST api to manage Families and their members. 
It's a Java application developed with Spring Boot and containerized on Docker.

## Pre-Requisites
 - JDK 8+
 - Mysql 5.7+
 - Maven 
 - Docker 

## Setup environment

First you must download Repository from https://github.com/RuiPinh0/challange to you system.
In order to run the application you need to open comand line, go to project directory and run the following comand:
   - docker-compose up --build

after this the project will compile and load automatically and you're ready to test the API.


## Known issues
in case docker compose does not work you must go to dockerfile.build and comment all lines and add the following commands:
 - ADD /target/families-0.0.1-SNAPSHOT.jar app.jar
 - ENTRYPOINT ["java", "-jar", "app.jar"]
 - EXPOSE 8080
 
 after this you must run on CMD mvn clean install and then re-run 'docker-compose up --build' command.
 in case you prefer run only locally, you must change datasource properties on properties file in conformity with your system and to run you must use the command Java -jar families-0.0.1-SNAPSHOT.jar after the command mvn clean install. 
 
### Notes
Postman collections are inside a folder on the project 
