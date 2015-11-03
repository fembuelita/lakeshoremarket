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

Service layer contains the services for the API as well as several test classes for testing primary site features.

## External Apps
Our app is powered by Heroku, and we are also paying a small sum for a Digital Ocean VPS setup to use MySQL without the limitations imposed by Heroku. We may eventually migrate to PostGRES, but not at this point.  

  1. [Heroku](http://lsm1.herokuapp.com/services/lsm)  
  2. [Digital Ocean](http://159.203.100.120/) *You can connect to PHPMyAdmin on this server using the credentials found in the project source code if you'd like to examine the database visually*    


## How to use the API
The API contains many services available to clients and partners of Lakeshore Market. We are currently developing full documentation; however, in the mean time you may find code samples, endpoints, and sample data in our data and URI mapping spreadsheet. The latest stable version can be found on [Google Docs](https://docs.google.com/spreadsheets/d/1KBOr2eQydpayd_6rlP5mEk_oogGoUVmisSFxV7XJE3w/edit?usp=sharing)  