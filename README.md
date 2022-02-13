# Capabilities-App-Full-Stack
Simple Capability-App with ReactJS, Spring Boot and Postgres.

## Table of contents
* [General info](#general-info)
* [Deploy status](#deploy-status)
* [Technologies-Front-end](#technologies-front-end)
* [Technologies-Backend](#technologies-backend)
* [Setup](#setup)
* [Project Tree](#project-tree)

## General info
This project is a simple Capability-App where you learn basic CRUD using ReactJS, Redux, Spring Boot and Postgres.

## Deploy status
Both front & backend are running on different dynos in Heroku free tier with automatic deployment from Github.  
Heroku Postgres is used as database.  

[capabilities-app-frontend](https://capabilities-app-frontend.herokuapp.com/) envirnoment for the front end. Not yet finished. As it is a free tier needs a little time to load.  
[capabilities-app-backend](https://capabilities-app-backend.herokuapp.com/) envirnoment for the backend. The /error page is not configured so whitelabel error shows. Test through POSTMAN (Routes will be added)

## Technologies-front-end
Front-end technologies & dependencies are:
* Axios version: "0.18.0"
* Bootswatch theme version: "5 "
* Classnames version: "2.2.6"
* Dotenv version: "14.3.2"
* Fontawesome version: "5.6.3"
* React version: "16.7.0"
* React-dom version: "16.7.0"
* React-modal version: "3.8.1"
* React-redux version: "6.0.0"
* React-router-dom version: "4.3.1"
* Redux version: "4.0.1"
* Redux-thunk version: "2.3.0"

## Technologies-backend
Backend technologies & dependencies are:
* Spring Boot version: "2.6.1"
* Java version: "11"
* Spring-boot-starter-data-jpa
* Spring-boot-starter-hateoas
* Spring-boot-starter-web
* Postgresql version: "42.3.1"
* Lombok version: "1.18.22"
* Validation-api version: "2.0.1.Final"
* Hibernate-validator version: "6.0.20.Final"
* Maven
	
## Setup
To run this project, TBA
```
TBA
```

## Project Tree
```
├───capabilities-HATEOAS-backend
│   ├───.idea
│   │   └───libraries
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───guleksiredi
│   │   │   │           └───capabilitieshateoasbackend
│   │   │   │               ├───assembler
│   │   │   │               ├───data
│   │   │   │               ├───domain
│   │   │   │               ├───exceptions
│   │   │   │               ├───repositories
│   │   │   │               ├───resources
│   │   │   │               └───services
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───guleksiredi
│   │                   └───capabilitieshateoasbackend
│   └───target
│       ├───classes
│       │   └───com
│       │       └───guleksiredi
│       │           └───capabilitieshateoasbackend
│       │               ├───assembler
│       │               ├───data
│       │               ├───domain
│       │               ├───exceptions
│       │               ├───repositories
│       │               ├───resources
│       │               └───services
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       ├───maven-status
│       │   └───maven-compiler-plugin
│       │       ├───compile
│       │       │   └───default-compile
│       │       └───testCompile
│       │           └───default-testCompile
│       ├───surefire-reports
│       └───test-classes
│           └───com
│               └───guleksiredi
│                   └───capabilitieshateoasbackend
└───capabilities-react-frontend
    ├───node_modules
    ├───public
    └───src
        ├───actions
        ├───components
        │   ├───CapabilityTool
        │   └───Layout
        └───reducers
```
