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

        <title>Scribe | Create Document</title>

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
				<li><a href="${pageContext.request.contextPath}/directory">Directory</a></li>
			</ul>
		</div>
        
        <div class="flex-container">
        
        <section class="body">
        
        <h2>Create New Document</h2>
        
	        <form class="center" action="./create-doc" method="post">
	        
		        <c:if test="${empty folderList}">
		        	<p>Please create a folder before creating a document</p>
		        </c:if>
	        
		        <c:if test="${!empty folderList}">
		        	<div class="line">
				        <label for="title">Title</label>
				        <input type="text" name="title"/>
			        </div>
			        
			        <div class="line">
				        <label for="folder">Folder</label>
				        <select name="folder">
				        	<c:forEach items="${folderList}" var="fol">     		
				        		<option value="${fol.id}">${fol.title}</option>
				        	</c:forEach>
				        </select>
			        </div>
			        
			        <div class="line">
			        	<textarea name="content" rows="10" cols="70"></textarea>
			        </div>
			        
			        <div class="line">
			        	<input type="submit" value="Create" name="submit" id="submit"/>
			        	<input type="reset" value="Reset" name="reset" id="reset"/>
			        </div>
			        
			        <p>${titleBlank}</p>
			        
			   	</c:if>
		        
			</form>
	        
        </section>
        
        </div>

        </div>

        <footer>
            <p class="center">Scribe &copy; Jessica Hoyer 2021</p>
        </footer>
</head>
<body>