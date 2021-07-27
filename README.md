
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

## Guide to use the application:

- Create Person or owner, take note of person id.
[http://localhost:8080/swagger-ui.html#/person/savePerson](
http://localhost:8080/swagger-ui.html#/person/savePerson)

- Create Vehicle.  Take note of vehicle id.
[http://localhost:8080/swagger-ui.html#/vehicle/saveVehicle](
http://localhost:8080/swagger-ui.html#/vehicle/saveVehicle)

- Register Vehicle to Owner.  Enter person id and vehicle id from previous create post.
[http://localhost:8080/swagger-ui.html#/register%20vehicle/saveRegisterVehicle](http://localhost:8080/swagger-ui.html#/register%20vehicle/saveRegisterVehicle)


- Check the registrations
[http://localhost:8080/swagger-ui.html#/register%20vehicle/getRegisterVehicle](http://localhost:8080/swagger-ui.html#/register%20vehicle/getRegisterVehicle)

- Unregister vehicle from owner by updating registration.  Remove person_id element in the json request. 
[http://localhost:8080/swagger-ui.html#/register%20vehicle/putRegisterVehicle](
http://localhost:8080/swagger-ui.html#/register%20vehicle/putRegisterVehicle) 

- Check the registrations to see the vehicle is no longer register to owner.
[http://localhost:8080/swagger-ui.html#/register%20vehicle/getRegisterVehicle](http://localhost:8080/swagger-ui.html#/register%20vehicle/getRegisterVehicle)

## GitHub
Check [vehicle_registration](https://github.com/orengoreng/vehicle_registration) for code updates.




