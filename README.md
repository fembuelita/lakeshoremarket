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

Service layer contains the services for the API.

## External Apps
Our app is powered by Heroku, and we are also paying a small sum for a Digital Ocean VPS setup to use MySQL without the limitations imposed by Heroku.  

  1. [Heroku](http://lsm1.herokuapp.com/services/lsm)  
  2. [Digital Ocean](http://162.243.94.35/) 

## How to use the API
For code samples, endpoints, and sample data, please visit our data and URI mapping spreadsheet. The latest stable version can be found on [Google Docs](https://docs.google.com/spreadsheets/d/1npm2CYr63gfPM2FyWcdhKqa8QMi1JPfQk2Z5VKjELGk/edit?usp=sharing). For a full list of classes and methods implemented in this project, please consult our Javadoc (accessible in the "doc" folder of this repository). The entrypoint URL for Lakeshore Market is [http://lsm1.herokuapp.com/services](http://lsm1.herokuapp.com/services).

## Additional Information
The front-end repository for Lakeshore Market can be accessed [here] (https://github.com/elliottpost/lsm-front-end).
