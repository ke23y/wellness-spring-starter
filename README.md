# wellness-spring-starter
A generic starter project for Springboot based Java project. Use maven as the build automaton tool 

### Running the starter
This project can be built and run using maven wrapper. After clonning the repo, use following  commands:
* Build command: `./mvnw clean install`
* Run command on local server, port 8080: `./mvnw spring-boot:run`


### Testing the starter
Test endpoint supporter at `/greet`. To check health, after spinning up the server, enter`curl localhost:8088/greet` from command line, and server should greet you back! 

### Dependency 
Following dependencies have been added to the project and managed by pom.xml: 
- Spring Web 
- lombock 
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

