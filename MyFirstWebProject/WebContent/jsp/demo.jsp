<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<p>Thời gian hiện tại </p>
	
	<%java.util.Date date = new java.util.Date(); %>
	<h2>
	<%=date.toString()%>
	</h2>
</body>
</html>