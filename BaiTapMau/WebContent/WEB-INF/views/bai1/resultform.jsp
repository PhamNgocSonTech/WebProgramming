<%@page import="vn.baimau.b1.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Form</title>
</head>
<body>
     <tr>
             <td>${student.fname}</td>
             <td>${student.lname}</td>
             <td>${student.email}</td>
             <td>${student.gender}</td>
             <td>${student.hobbies}</td>
             <td>${student.birthday}</td>
     </tr>
      

</body>
</html>