# Trident Hotels Management System

## Primary requirements:

- Front-end: Angular Framework - UI Design
- Back-end: Spring Boot Data JPA and RESTful Web Services (.java and .properties files are required here, Please follow the programming and SQL standards). JSP Not Required.
- Database: MySQL
- IDE: Eclipse/STS and Visual Studio Code
- Servers: Embedded Tomcat, Angular Live Development Server
- Build Automation: Maven
- API Testing Tool: Postman

## Project Overview

Trident Hotels is a leading hotel chain in India which operates across all metropolitan cities. Trident club rooms are designed for discerning business travellers. Plethora of services and amenities are provided. We invite you at Trident Hotels for your upcoming trip. The hotel already operating online with all locations having a single site resulting in higher traffic and difficulty in management 

Trident Hotels has decided to make a standalone web portal for Hyderabad location. This document specifies the list of requirements that are needed for the initial phase of the web launch. 

## Scope of project:

In Scope 
Following are the key features that needs to be implemented for User/Guest and Admin: 
Admin 
1.	CRUD Guests 
2.	CRUD Users 
3. 	CRUD Services 
4. 	Change Admin Password 
5. 	Login 
(NOTE: CRUD- Create Retrieve Update Delete) 
Customer/Guest 
1.	CRUD Guest 
2.	CRUD User 
3.	Change Password 
4.	View Services 

## DB SCHEMA: 

```
CREATE TABLE IF NOT EXISTS `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_in` varchar(255) DEFAULT NULL,
  `check_out` varchar(255) DEFAULT NULL,
  `noguest` int(11) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact` bigint(20) DEFAULT NULL,
  `servicedesc` varchar(255) DEFAULT NULL,
  `servicename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

## USE CASES:

There will be two types of users who will be using this application: 
1.	Admin 
2.	Customer/Guest 

Key Responsibilities:  
Admin – Responsible for managing the guest booked and User registered on Trident hotels 
Customer – Update booked guest and their registration details.  

## ADMIN SCOPE:

Admin View Menu Items 
Admin should login with credentials. 
Admin home page has guests, users, and services list. Application fetches the guests, users, and services list from the database. 
List of menu items shown to the admin with following details about each menu item: 
Guest (Id, Name, check-in date, check-out date, No. of rooms, No. of guest) 
User (Id, Name, Phone Number, email, address) 
Services (Id, Service Name, Service Description, Contact) 
Change Password 
Logout 

Note: Continue for all the features – ex: admin add/ admin update/ admin delete. 

## CUSTOMER SCOPE:

Customer/Guest View Menu Items 
User/Guest should login with credentials. 
Guest/User home page has guest, user and services list. Application fetches the guest, user and services list from the database. 
List of menu items shown to the Guest/User with following details about each menu item: 
Guest (Id, Name, check-in date, check-out date, No. of rooms, No. of guest) 
User (Id, Name, Phone Number, email, address) 
Services (Id, Service Name, Service Description 
Change Password 
Logout 
