<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe</title>

        <!-- stylesheet -->
        <spring:url value="/resources/css/main.css" var="mainCss"/>
        <link href="${mainCss}" rel="stylesheet" >
        
        <!-- main logo -->
        <spring:url value="/resources/images/logo.png" var="logo"/>

        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Shadows Into Light&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento&display=swap" rel="stylesheet">
</head>
<body>

	<!-- start header -->
	
	<header>
		<nav>
			<ul>
				<li><p class="title">Scribe</p></li>
				<li><a href="index.html" class="selected">Home</a></li>
				<li><a href="login.html">Login</a></li>
				<li><a href="register.html">Register</a></li>
			</ul>
		</nav>
	</header>

	<!-- end header -->

	<!-- wrapper -->

	<div id="wrapper">

	<h1>Welcome to Scribe</h1>
	
		<!-- start content section -->
            
		<section class="content">
		
		<p>Scribe is an online writing application that will store all of your writing documents on one account and allow you to store each document into separate folders. Its versatility means you can organize all types of writing - from novels to class notes.</p>
		
		<p>Create documents and folders and use edit mode to edit them and to move documents into different folders. The HTML text editor allows you to style your content however you would like using bold, italics, and code blocks.</p>
            
		</section>
		
		<!-- end content section -->
            
	</div>
	
	<!-- end wrapper -->

	<!-- start footer -->
	
	<footer>
		<p class="center">Scribe &copy; Jessica Hoyer 2021</p>
	</footer>
	
	<!-- end footer -->
</body>
</html>