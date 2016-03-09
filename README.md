Zooplus Challenge
=================
[![Build Status](https://travis-ci.org/jomoespe/zooplus-challenge.svg?branch=master)](https://travis-ci.org/jomoespe/zooplus-challenge)

Description.


## Technology stack

  - Development and building lifecycle
    - Maven
    - Java 8
    - Spring
      - data-jpa
      - security
      - web
  - Continous integration
    - GitHub
    - Travis
  - Infrastructure
    - H2 database
    - Docker 
    - Digital Ocean


## Build

    $ mvn clean verify


## Run the project

This project can run as Java stand alone application or can run as a Docker container. Once the application is up and running you can [access the application from your favorite browser](http://localhost:8443/ "See application on localhost")


### Runn as Java standalone application

Once the application is built, you can run as stand alone application. From the project root simply:

    $ java -jar target/challenge.jar


This will start the application listening on **port 8443**. To run in another host, this must has been installed a Java Virtual Machine.


### Run as Docker container


    $ docker build -t <container_tag> .

    $ docker build -t jomoespe/zoopluschallenge .

