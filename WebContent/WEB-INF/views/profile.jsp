<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
            
            <div class="line">
            	<a href="edit-profile" class="button">Edit Profile</a>
	            <a href="delete-profile" class="button">Delete Account</a>
            </div>
            
			<p>${profileEditSuccess}</p>
            
            <p class="folder"><b>Directory</b></p>
            
	            <c:if test="${empty folderList}">
        			<p>Nothing to display.</p>
        		</c:if>
        		<c:if test="${!empty folderList}">
		        	<c:forEach items="${folderList}" var="folder">
		        	<p><b>Folder:</b> ${folder.title}</p>
		        	<p><b>Documents:</b></p>
		        		<c:if test="${empty folder.documents}">
		        			<p>None</p>
		        		</c:if>
			        	<c:if test="${!empty folder.documents}">
					        <c:forEach items="${folder.documents}" var="doc">
						       <p>${doc.title}</p>
					        </c:forEach>
			       		</c:if>
			    	</c:forEach>
	       		</c:if>

			</section>
            
        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>