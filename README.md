# Bootee


[![Build Status](https://travis-ci.org/vincedgy/bootee.svg?branch=master)](https://travis-ci.org/vincedgy/bootee)

_net.vincedgy.garden.bootee_

## Mission

Sarting from this reference [https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin]
and the excellent and fun Josh Long's talk about Bootiful Application [https://www.youtube.com/watch?v=9Di_mwsL6zI], 
and working a lot on SpringBoot development, microservices with Spring Cloud etc...
I decided to face Kotlin and Gradle both together to build the same Reservation type application.

## Goals

- Observe Kotlin in depth and use Gradle and start living with Maven.
- Continue to master SpringCloud

## Instruction & Installation

Very classic beginning on [http://start.spring.io] but choose the good options

Checkout the build.gradle content for details.

## Fun stuffs

Don't forget to pass to JVM options -Dspring.output.ansi.enabled=ALWAYS if you want coloration.
I don't know why, but because of Gradle or Kotlin it didn't appear by his own.


### Classes & Constructors

Less much code but needs some adaptation when it's time to add a specific constructor (with a parameter for isntance)

### Stream and lambdas

This was quite touchy since I know both on a "not that bad" level in Java 8
but it's all but different on Kotlin (with 'it' usage for instance)

Definitely check this reference on SOF :
[https://stackoverflow.com/documentation/kotlin/707/java-8-stream-equivalents#t=201607211216224974548]