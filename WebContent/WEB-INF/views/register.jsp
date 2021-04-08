<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | Register</title>

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
					<li><a href="index.html">Home</a></li>
					<li><a href="login.html">Login</a></li>
					<li><a href="register.html" class="selected">Register</a></li>
				</ul>
			</nav>
        </header>


        <div id="wrapper">

        <section class="content">
        
        <h2>Register</h2>
        
        <p>Register for an account with Scribe here!</p>
        
        <p>Please pick a username longer than 2 characters and no more than 30 characters, and a password longer than 4 characters and no more than 20 characters.</p>
        
        <p>All usernames are unique for each account, so if the one you pick is taken, please choose another one.</p>

            <form class="center" action="./register" method="post">

                <div class="line">
                    <label for="username">Username</label>
					<input type="text" name="username"/>
                </div>

                <div class="line">
                    <label for="password">Password</label>
                    <input type="password" name="password"/>
                </div>
                
                <div class="line">
                    <label for="c-password">Confirm Password</label>
                    <input type="password" name="c-password"/>
                </div>

                <div class="line">
                    <input type="submit" value="Register" name="submit" id="submit"/>
                    <input type="reset" value="Reset" name="reset" id="reset"/>
                </div>
                
                <p>${usernameBlank}</p>
                <p>${usernameTaken}</p>
                <p>${passwordBlank}</p>
                <p>${passwordMismatch}</p>
                <p>${usernameLength}</p>
                <p>${passwordLength}</p>
                
            </form>
            
            </section>
            
        </div>
            
        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>

</body>
</html>