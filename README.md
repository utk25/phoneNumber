<==================STEPS TO RUN =========================>

PREREQUISITES:
MySQL

STEPS to follow before running application
Navigate to src/main/resources/application.properties and change the Database properties like password and database name

Create a database in your local system and give the same name in src/main/resources/application.properties

Run command gradlew bootRun. (chmod a+x gradlew && ./gradlew bootRun for Linux machines)
Tomcat is up and connected to database.

If you are seeing DDL errors while launching the application then:

Drop the database you created

RUN these two commands in your mysql client

SET GLOBAL default_storage_engine = 'InnoDB';

create database <DATABASE_NAME> character set latin1;

RUN the application again using command gradlew bootRun. (chmod a+x gradlew && ./gradlew bootRun for Linux machines)

The end point URLs for PhoneNumber are:


POST
http://localhost:8080/phoneNumber

{
	"clientId" : 1
}

POST
http://localhost:8080/specialPhoneNumber

{
	"clientId" : 1
	"specialNumber" : 9999999999
}

By Default 2 tables are created in Database by names "Offered" and "Hired".


Please enter correct values in url path so as to avoid any kind of exception as all the corner cases aren't handled here.
