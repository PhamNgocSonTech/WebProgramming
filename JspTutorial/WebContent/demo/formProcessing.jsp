<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Parameter values:</h3>
  <%
	
  //Lấy giá trị của tham số userName.
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");  
 // Lấy danh sách các giá trị tham số address
    String[] addresses = request.getParameterValues("address");    
  %>
  User Name: <%=userName %> <br>
  Password: <%=password %> <br>
  First Name: <%=firstName %> <br>
  Last Name: <%=lastName %> <br>
  Gender: <%=gender %> <br>
  <% if (addresses!= null)  {
       for(String address: addresses)  {
      %>
     Address: <%=address %> <br>
  <% } } %>
</body>
</html>