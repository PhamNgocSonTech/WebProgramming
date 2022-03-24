<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" import="java.io.*" %>    
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Error</title>
</head>
<body>
<h2>Some error in page</h2>
Message:
<%=exception.getMessage()%> 
<h3>StackTrace:</h3>
<%
  StringWriter stringWriter = new StringWriter();
  PrintWriter printWriter = new PrintWriter(stringWriter);
  exception.printStackTrace(printWriter);
  out.println("<pre>");
  out.println(stringWriter);
  out.println("</pre>");
  printWriter.close();
  stringWriter.close();
%>
</body>
</html>