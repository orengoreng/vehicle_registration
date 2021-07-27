
# vehicle-registration
Sample [Spring Boot MVC](http://projects.spring.io/spring-boot/) rest api to create vehicle, owner and register vehicle to owner. Uses [Swagger](https://swagger.io/) for rest template and memory database [h2](https://www.h2database.com/html/main.html)

## Requirement
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Installation
Use the package manager [mvn](https://maven.apache.org/download.cgi) to install app.
```bash
mvn clean install
```
## Running the application locally

You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

To open the main app page, enter this [link]
(http://localhost:8080/swagger-ui.html#/): 

```shell
http://localhost:8080/swagger-ui.html#/ 
```

If you want to access the h2 database memory, click this [link](http://localhost:8080/h2-console) to open the console for database query. See the User table to search for user info.

```shell
localhost:8080/h2-console
```
refer to the `application.properties` for the h2db access.

## GitHub
Check [vehicle-registration](https://github.com/orengoreng/vehicle-registration) for code updates.




