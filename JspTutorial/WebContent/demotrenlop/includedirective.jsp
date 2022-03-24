<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsp Include Directive</title>
</head>
<body>
<%@ include file="../fragment/header.html"%> 
  <h2>Jsp tutorial for Beginners</h2>
  Hi! This is Jsp Tutorial... 
  <%@ include file="../fragment/footer.html"%>
</body>
</html>