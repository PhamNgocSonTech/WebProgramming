<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<c:set var="mangonngu" value="${param.radio_mangonngu }"/>
<c:if test="${not empty mangonngu}">
		<f:setLocale value="${mangonngu}" scope="session"/>
</c:if>
<br>
<f:setBundle basename="resource" scope="session"/>
<form action="index.jsp" method="post">
<br>
<f:message key="languagemessase" ></f:message>
<input type="radio" name="radio_mangonngu" value="vi-VN"  
		<c:if test="${mangonngu=='vi-VN'}">checked</c:if>	>
		
<f:message key="vn"></f:message>
<input type="radio" name="radio_mangonngu" value="en-US"  
		<c:if test="${mangonngu=='en-US'}">checked</c:if>	>
		
<f:message key = "en"></f:message>
<input type="submit" name="submit" value="<f:message key='choosebutton' > </f:message>"> <br>
<hr>
<table border="0">
		<tr> 
			<td> <f:message key="username" > </f:message> </td>
			<td> <input type="text" name="txtusername" value="${user.username}"> </td>
		</tr>
		<tr> 
			<td> <f:message key="pass"> </f:message> </td>
			<td> <input type="text" name="txtpassword" value="${user.password}"> </td>
		</tr>
		<tr> 
			<td colspan="2"> <input type="submit" name="submit" 
			value="<f:message key='login'></f:message>" >  </td>
		</tr>
</table>
</form>

</body>
</html>