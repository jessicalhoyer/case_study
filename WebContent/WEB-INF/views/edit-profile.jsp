<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | Edit Profile</title>

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

            <form action="./edit-profile" method="post">
            
            	<label for="username">Username</label>
            	<input type="text" name="username" value="${currentUser.username}"/>
            	<br/>
            	<label for="password">Password</label>
            	<input type="password" name="password"/>
            	<br/>
            	<label for="c-password">Confirm Password</label>
            	<input type="password" name="c-password"/>
            	
            	<input type="submit" value="Submit" name="submit"/>
            	
            <p>${usernameBlank}</p>
            <p>${usernameTaken}</p>
            <p>${passwordMismatch}</p>
            
            </form>
            
            <a href="profile">Back to Profile</a>
            
			<p>${profileEditSuccess}</p>
            
        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>