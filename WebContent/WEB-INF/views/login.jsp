<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | Login</title>

        <!-- stylesheet -->
        <spring:url value="/resources/css/main.css" var="mainCss"/>
        <link href="${mainCss}" rel="stylesheet" >

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
				<li><a href="index.html">Home</a></li>
				<li><a href="login.html" class="selected">Login</a></li>
				<li><a href="register.html">Register</a></li>
			</ul>
		</nav>
	</header>

	<!-- end header -->
	
	<!-- start wrapper -->
	
	<div id="wrapper">
	
		<!-- start content section -->
        
		<section class="content">
        
        <h2>Login</h2>
        
			<!-- start form -->

			<form class="center" action="./login" method="post">
            
                <div class="line">
	                <label for="username">Username</label>
	                <input type="text" name="username" id="username"/>
                </div>

                <div class="line">
	                <label for="password">Password</label>
	                <input type="password" name="password" id="password"/>
                </div>

                <div class="line">
	                <input type="submit" value="Login" name="submit" id="submit"/>
	                <input type="reset" value="Reset" name="reset" id="reset"/>
                </div>
                
                <!-- validation check below -->
                <p>${loginFailed}</p>
                
            </form>
            
            <!-- end form -->

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