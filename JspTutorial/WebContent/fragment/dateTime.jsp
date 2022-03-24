<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  Date now = new Date();
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS"); 
%>
<h4>Current Time:</h4>
<%=df.format(now)%>
</body>
</html>