<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Expression Language Demo</title>
</head>
<body>
<jsp:useBean id="emp"
      class="tutorial.jsp.beans.Employee">
      <jsp:setProperty name="emp" property="empNo" value="E01" />
      <jsp:setProperty name="emp" property="empName" value="Son" />
  </jsp:useBean> 
  <br>
  Emp No: <input type="text" value = "${emp.empNo}">
  <br>
  Emp Name <input type="text" value = "${emp.empName}"> 
</body>
</html>