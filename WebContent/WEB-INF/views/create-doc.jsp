<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | ${currentUser.username}'s Directory</title>

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
					<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
					<li><a href="${pageContext.request.contextPath}/directory">Directory</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</ul>
			</nav>
	            
        </header>

        <div id="wrapper">
        
        <div id="controlnav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/create-folder">Create Folder</a></li>
				<li><a href="${pageContext.request.contextPath}/create-doc">Create Document</a></li>
				<li><a href="${pageContext.request.contextPath}/sort/${currentUser.id}">Sort</a></li>
			</ul>
		</div>
        
        <div class="flex-container">
        
        <section class="body">
        
        <h2>Create New Document</h2>
        
        <form:form action="./create-doc" method="post" modelAttribute="newDoc">
        
        
        <label for="title">Title</label>
        <form:input path="title" style="border:1px solid black;"/>
        <form:errors path="title"/>
        <br/>
        <label for="folder">Folder</label>
        <form:select path="folder">
        	<c:forEach items="${folderList}" var="folders">
        		<form:option value="${folders.id}">${folders.title}</form:option>
        	</c:forEach>
        </form:select>
        
        <br/>
        <form:textarea path="content" rows="10" cols="70" style="border:1px solid black;"/>
        <br/>
        <input type="submit" value="Create" name="submit" id="submit"/>
        
        </form:form>
        
        <p>${errorList}</p>

        </section>
        
        </div>

        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>