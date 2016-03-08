Zooplus Challenge
=================
[![Build Status](https://travis-ci.org/jomoespe/zooplus-challenge.svg?branch=master)](https://travis-ci.org/jomoespe/zooplus-challenge)

Description.

  - Java 8
  - Maven
  - Spring
    - data-jpa
    - security
    - web
  - H2 database
  - Docker 


## Build

    $ mvn clean verify


## Run the project

### As Java standalone application

Once the project is built, you can ru it with:

    $ java -jar target/challenge.jar

### As Docker container


    $ docker build -t <container_tag> .

    $ docker build -t jomoespe/zoopluschallenge .

