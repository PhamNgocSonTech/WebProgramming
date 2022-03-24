<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Use Bean</title>
</head>
<body>
<jsp:useBean id="helloBean"
      class="tutorial.jsp.beans.HelloBean"></jsp:useBean> 
  <h3>Say Hello:</h3>
  <jsp:getProperty name="helloBean" property="hello" />    
  <!-- Set property name for helloBean -->
  <jsp:setProperty  name="helloBean" property="name" value="JSP"/>
  <h3>Say Hello after setName</h3>
  <jsp:getProperty name="helloBean" property="hello" /> 
</body>
</html>