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
	String ImgPath = (String)request.getAttribute("ImgPath");
	String message = (String)request.getAttribute("message");
	
	%>
	<h2><%= message %></h2>
    <div id="image" style="width:400px; height:300px; background:#CCCCCC; float:left;">
        <img src=<%= "uploadfile\1001.jpg" %> />
    </div>
    


</body>
</html>