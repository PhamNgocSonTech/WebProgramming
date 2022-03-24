<%@page import="vn.baimau.b2.bean.UserLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration View </title>
</head>
<body>
	<tr>
		<td> ${user.fname}    </td>
		<td> ${user.lname}   </td>
		<td> ${user.email}   </td>
		<td> ${user.password} </td>
		<td> ${user.date}    </td>
		<td> ${user.gender}  </td>
		
		
	</tr>
</body>
</html>