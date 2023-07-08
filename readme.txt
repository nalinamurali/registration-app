REGISTRATION APP
================

Technologies Used
------------------
Java 8

Spring Boot 2.3.4.RELASE

UI : ThymeLeaf

Postman (to check REST API endpoints)


Database used
--------------

H2 Embedded database

URL for database ui : http://localhost:8080/registration/h2-ui

		jdbc url : jdbc:h2:mem:mydb

		username : sa

		password : password
		
Database script to create table and select from table 
-----------------------------------------------------
CREATE TABLE IF NOT EXISTS USER(ID INT PRIMARY KEY, NAME VARCHAR(255), EMAIL VARCHAR(255), AGE INT, GENDER VARCHAR(10));

select * from user;



URL's and other details
-----------------------

1. Webform for Registration can be accessed via http://localhost:8080/registration

	Functionalities:
		1. Create Registration
		2. List all the registered users
		3. Find a registration with keyword 
		
	known Limitations
		1. Finding with age is excluded.

 2. API for registration - End points are given below
  
 		1. List all registered users : http://localhost:8080/registration/api/registrations
		2. Create New registration :  http://localhost:8080/registration/api/registration/register
		3. Search a user :  http://localhost:8080/registration/api/registration/search

JSON sample to create new registration,

{
    "name": "API POST",
    "gender": "OTHER",
    "email": "abc@def.com",
    "age": 99
}


Status Check (Shell script, Crontab)
------------------------------------

Application Status is checked using Actuator - /health end point "http://localhost:8080/registration/actuator/health"



Copy statuscheck.sh to any folder. change permissions for the file as appropriate.

Create a crontab with below entry, (if shell script path is under a directory, specify the exact path)

*/5 * * * * sh statuscheck.sh date >> /tmp/statuslog

Above should create log entry in the file every 5 minutes checking the acutuator