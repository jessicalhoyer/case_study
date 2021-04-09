# Scribe (case_study)

My case study project for my TEKSystems Full Stack Java Developer bootcamp.

## Description

Scribe is a web application that will allow users to register an account that will let them create, edit, and delete documents and folders and store those documents in different folders.

## User Stories

* As a user, I want an application to store all of my writing documents in different folders.
* As a user, I want to be able to create an account, so that I can store all of my writing documents and folders in it.
* As a user, I want to be able to view all of my folders and documents, so that I can see them easily.
* As a user, I want to be able to edit my documents, so that I can add and remove content from them.
* As a user, I want to be able to edit my folders, so that I can change their titles.
* As a user, I want to be able to delete my documents and folders, so that I can remove them from my account.
* As a user, I want to be able to edit my profile, so that I can change my username and password.
* As a user, I want to be able to delete my profile, so that I can remove my account from the application.

## Features

* Account creation
* Folder creation
* Document creation
* Folder editing
* Document editing
  * With HTML editor that allows bold, italic, blockquote, and code block features
* Move documents to different folders
* Folder deletion
* Document deletion
* Account deletion

## Technologies and Skills

Scribe is a dynamic web Java Spring MVC application that utilizes Maven dependencies. It has full CRUD functionality using JpaRepositories and custom SQL queries. It uses Service classes to access the different repository interfaces. Models are used to connect with the database. The database is built with MariaDB using the HeidiSQL GUI interface and run with Tomcat server on localhost:8080. Testing is done using JUnit and Mockito.

* HTML
* CSS
* Java
* JpaRepositories
* SQL
* Database design
* JUnit and Mockito
* Spring MVC
* Maven
* Content writing
* UI/UX wireframes
* Documentation

## Challenges

* The first challenge I faced with this project was trying to set up the Models, their relationships, and to get them to communicate correctly back and forth from the database. It required research and a lot of trial and error, but I eventually got it to work correctly.
* The biggest challenge I faced, however, was getting the edit-doc page to function correctly. I would get a variety of different errors depending on what I did and sometimes it failed to show any errors at all despite still not functioning correctly. At one point, I thought I had it working correctly, but it turned out that I was simply recreating documents instead of editing them. I eventually had to rewrite the entire method to use individual `@RequestParam`s instead of `@ModelAttribute` and it worked correctly!
* After this, my next challenge was figuring out how to validate all of my data correctly and prevent users from submitting blank input fields. To do this, I had to rewrite all of my methods again to use `@RequestParam` instead of `@ModelAttribute`. I suspect that this was due to the constraints on my database tables and I'm curious about diving in and seeing if there is a better, more elegant solution.

## Credit

Background image from subtlepatterns.

Copyright Jessica Hoyer (c) 2021
