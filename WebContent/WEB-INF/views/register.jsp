<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | Register</title>

        <!-- stylesheet -->
        <link rel="stylesheet" href="css/main.css">

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
                    <li><a href="about.html">About</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><a href="register.html" class="selected">Register</a></li>
                </ul>
            </nav>
        </header>


        <div id="wrapper">

            <form class="center">

                <h2>Register</h2>
                
                <div class="line">
                    <label for="username">Username</label>
                    <input type="text" name="user" id="user"/>
                </div>

                <div class="line">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password"/>
                </div>

                <div class="line">
                    <input type="button" value="Submit" name="submit" id="submit"/>
                    <input type="reset" value="Reset" name="reset" id="reset"/>
                </div>
            </form>
        </div>
            
        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>

</body>
</html>