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

        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Shadows Into Light&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Quattrocento&display=swap" rel="stylesheet">
</head>
    
<body>

	<!-- start header  -->

	<header>
		 <nav>
			<ul>
				<li><p class="title">Scribe</p></li>
				<li><a href="${pageContext.request.contextPath}/index.html">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/login.html">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/register.html">Register</a></li>
			</ul>
		</nav>
	</header>

	<!-- end header -->
	
	<!-- start wrapper -->

	<div id="wrapper">
            
		<section class="content">

		<h2>Access denied</h2>
            
		<p>You must be logged in to view this page.</p>
            
		</section>
            
	</div>

	<!-- end wrapper -->
	
	<!-- start footer -->

	<footer>
		<p class="center">Scribe &copy; Jessica Hoyer 2021</p>
	</footer>

	<!-- end footer -->
</body>
</html>