<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" import="myData.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>Show</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
	<% 
	ServletContext servData = getServletContext();    
	String ImgPath = (String)request.getAttribute("img");
	String message = (String)request.getAttribute("message");
	System.out.println(ImgPath);
	
	%>
	<h2><%= message %></h2>
    <div id="image" style="width:400px; height:300px; background:#CCCCCC; float:left;">
        <img src=<%= ImgPath %> alt="No Image"/>
    </div>
    


</body>
</html>