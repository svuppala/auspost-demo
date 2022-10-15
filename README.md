# austpost-demo

The auspost-demo application is created using a SpringBoot application to develop REST APIs that will store and access suburb and postcode combinations.

## Docker Postgres Installation (Required for Persistence)

Please note that installation of Docker will be required. Please follow the steps in order.

```bash
> docker pull postgres:15-alpine

> docker run --name postgresdb -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:15-alpine

> docker exec -it postgresdb bash

> psql -U postgres

> create database test;
```

## Spin Up Backend Service
The user can either load the project into a code editor such as IntelliJ and then spin up the application using the Run button or the user could use the command provided below in the terminal from the Project root.
```bash
java -jar ./target/demo1-0.0.1-SNAPSHOT.jar
```