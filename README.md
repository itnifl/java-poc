# TechStack POC Test with Java 17

## 1. Prerequisites
Make sure you have the following:
- JAVA 17: https://www.oracle.com/java/technologies/downloads/
- Docker: https://www.docker.com/products/docker-desktop
- Git BASH: https://gitforwindows.org/
- Visual Studio Code: https://code.visualstudio.com/download
- MySQL Workbench: https://dev.mysql.com/downloads/workbench/
- After installing VS Code, see https://code.visualstudio.com/docs/java/java-spring-boot - Include: Spring Boot DevTools


## 2. Clone the repository
1. abcdefg

## 3. MySQL in Docker
To start MYSQL in Docker (first install Docker: https://www.docker.com/products/docker-desktop):

`application.yml` already contains connection information to this DB.
Perform the following command from this project root in your terminal:
```shell script
docker-compose up -d
```

This will start a MySQL instance in your Docker setup.

## 4. Create the database and the schema
After this, run databaseSchema.sql in the ticketsales database to create the schema.
Roughly described:
 1. Use MySQL Workbench to connect to the MySQL server instances that you started in Docker.
 2. Use localhost as servername, use the username and password that is supplied in docker-compose.yml
 3. After connecting, create the database: CREATE DATABASE ticketsales;
 4. Then run the code found i databaseSchema.sql that you will find in this source code, see src\main\java\io\ticket\sales\database\schema. This can be done via MySQL Workbench.

## 5. Start the code in Visual Studio Code
1. Open VS Code
2. Go to File -> Open Folder and open the folder where you cloned and downloaded the code for this solution.
3. Code is written in Visual Studio Code and can be run from Visual Studio Code (for instance: Run -> Run without debugging). 


## 6. Test that the controllers reply
Code can then be tested via a browser or a REST Client.
After starting, the following urls are available:
- localhost:8080/feed
- localhost:8080/ticket
- localhost:8080/ticket/all

Browse to these and test that they reply. Use userame and password:
- b/p: user/userpass
- b/p: adminuser/adminpass

## 7. Perfom a manual test:
- Browse to localhost:8080/ticket/all, expected result: []
- Insert data to the MySQL database in Docker (I used MySQL Workbench for this):
```shell script
insert into user values (1, 'name', 'name', 'name', 2);
insert into event values (1, 1, 'event', 'event');
insert into ticket values(1, 1,
    1,
    'nameofticket',
    99,
    'ticket')
```
- Browse to localhost:8080/ticket/all, expected result: [{"id":1,"name":"nameofticket","price":99,"createdByUserId":1,"eventId":1,"description":"ticket"}]


Authorization is implemented, but users are hardcoded (this needs fixing). 
- b/p: user/userpass
- b/p: adminuser/adminpass


## Implements
- Example schema
- Example controllers
- Example ORM layer to the database
- Example Dependency Injecton
- Example SPRING REST API with MySQL in Docker
- Example authentication
- Example but empty test-project
- Verification/test of functioning stack


## Needs
- Authentication that is not hard coded
- Tests for controllers before proper controllers are implemented
- Real functionality for real business problems according to user stories
- Refined database schema
- The real deal


Happy coding!
