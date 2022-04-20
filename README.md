# wellness-spring-starter
This repo is a skeleton Spring Boot application used for coding interviews with the Wellness team.

### Running the application
This project can be built and run using maven wrapper. After clonning the repo, use following  commands:
* Build command: `./mvnw clean install`
* Run command: `./mvnw spring-boot:run`

After spinning up the server, enter `curl localhost:8088/hello` from command line, and server should greet you back! 

# Preparing for the Interview
1. Make sure you can clone this repository locally
2. Make sure you can compile and run the skeleton application
3. Open/import this project in your favorite IDE
4. Make sure your development environment is ready to code and run this application!

# Interview Coding Options
There are several options for the candidate to take:

1. Create a JPA-style "Repository" for Medication using an in-memory data structure.
2. Create CRUD APIs for Medication in the MedicationsController.
3. Create a basic Service layer - what belongs in the Service vs the Repository?
4. Write tests for the Repository, Service, or Controller
5. Write the in-memory Medications data to a file and load it back up on application startup.

### Dependencies
Following dependencies have been added to the project and managed by pom.xml: 
- Spring Web 
- Spring configuration processor

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#using-boot-devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-security)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-security-oauth2-client)

### Guides

The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

