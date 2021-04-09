<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Scribe | Directory</title>

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
				<li>Welcome ${currentUser.username}</li>
				<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
				<li><a href="${pageContext.request.contextPath}/directory">Directory</a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
		</nav>
	</header>
        
 	<!-- end header -->
 	
 	<!-- start wrapper -->

	<div id="wrapper">
	
		<!-- start control nav -->
        
		<div id="controlnav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/create-folder">Create Folder</a></li>
				<li><a href="${pageContext.request.contextPath}/create-doc">Create Document</a></li>
				<li><a href="${pageContext.request.contextPath}/edit-doc/${currentDoc.id}">Edit Mode</a></li>
			</ul>
		</div>
		
		<!-- end control nav -->
		
		<!-- start flex container -->
        
        <div class="flex-container">
        
	        <!-- start organizer section -->
	        
	        <section class="organizer">
		        <c:forEach items="${folderList}" var="folder">
		        <p class="folder">${folder.title}</p>
		        	
		        	<c:forEach items="${folder.documents}" var="doc">
			        <p class="doc"><a href="${doc.id}">${doc.title}</a></p>
			        </c:forEach>
		        
		        </c:forEach>
	        </section>
	        
	        <!-- end organizer section -->
	        
	        <!-- start body section -->
	        
	        <section class="body">
	        
	        <h2>${currentDoc.title}</h2>
	        
	        <p>${currentDoc.content}</p>

	        </section>
	        
	        <!-- end body section -->
        
        </div>
        
        <!-- end flex container -->

	</div>
	
	<!-- end wrapper -->

	<!-- start footer -->
	
	<footer>
		<p class="center">Scribe &copy; Jessica Hoyer 2021</p>
	</footer>
	
	<!-- end footer -->
</body>
</html>