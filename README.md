# LakeshoreMarket
Project for Web Services Programming (388/433) F15


Project Title:
Lakeshore Market (E-Commerce Website )
Project Description:
The goal of creating Lakeshore Market website is to sell goods and give the customer services online. E-commerce business is being used by most of the people these days. It is reasonable to say that the process of online shopping is becoming commonplace.  

The Lakeshore Market is implemented on a MVC architecture. The Lakeshore Market Java code can be listed down to 4 major components :  

  1. Model
  2. Domain
  3. Database Access Object
  4. Service

The Model component consists of the basic structure of the classes that correspond to the different database tables or entities. Objects created from the model components acts as a data holder or an envelope which will travel between different layers of the architecture.  

The Domain component comprises of the Business Logic. This is where all the manipulations to data is actually done.  

The Database Access Object Layer or the DAO layer is responsible for connection to the Lakeshore Market database. This layer uses the JDBC for interacting with the database.  

Service layer contains classes that are required to test the major functionalties of the Lakeshore Market.  

## External Apps
We are currently building the app out on two different apps to see which launch is easier.  

  1. [Heroku](lakeshoremarket.herokuapp.com)  
  2. [Digital Ocean](http://104.131.74.11:8080/lakeshoremarket/)  

Although neither app yet is fully functional, that will be the case when we implement the REST API.

## Steps to run on LocalHost
  1. For project 2, please import the sql-init.sql file found in docs/db for testing.  
  2. Once you import this file, open the project in Eclipse.  
  3. Navigate to the directory with the unit tests.  
  4. Run the unit tests.  
