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
        <header>
            <!-- logo here potentially -->
            <nav>
				<ul>
					<li><p class="title">Scribe</p></li>
					<li><a href="${pageContext.request.contextPath}/index.html">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/login.html">Login</a></li>
					<li><a href="${pageContext.request.contextPath}/register.html">Register</a></li>
				</ul>
			</nav>
        </header>


        <div id="wrapper">
            
            <section class="content">

            <h2>Invalid Request</h2>
            
            <p>The page you are trying to access does not exist.</p>
            
        </section>
            
        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>

</body>
</html>