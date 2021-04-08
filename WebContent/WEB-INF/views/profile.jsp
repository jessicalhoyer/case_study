<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | ${currentUser.username}'s Profile</title>

        <!-- stylesheet -->
        <spring:url value="/resources/css/main.css" var="mainCss"/>
        <link href="${mainCss}" rel="stylesheet" >

        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Shadows Into Light&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento&display=swap" rel="stylesheet">
        

    </head>
    <body>
        <header>
            <!-- logo here potentially -->
			<nav>
				<ul>
					<li><p class="title">Scribe</p></li>
					<li>Welcome ${currentUser.username}</li>
					<li><a href="profile">Profile</a></li>
					<li><a href="directory">Directory</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</nav>
	            
        </header>


        <div id="wrapper">
        
        	<section class="content">
        	
        	<h2>${currentUser.username}'s Profile</h2>

            <p><b>Username:</b> ${currentUser.username}</p>
            
            <p>Folder list and document list?</p>
            
            <a href="edit-profile" class="button">Edit Profile</a>
            <a href="delete-profile" class="button">Delete Account</a>
            
			<p>${profileEditSuccess}</p>
			
			</section>
            
        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>