<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.service.AccountProcService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Verification</title>
</head>
<body>
<%! int status=0; %>
<%
String user = request.getParameter("user");
String upwd = request.getParameter("pwd");
int uid=(new AccountProcService()).valUserLogin(user,upwd);
if(uid>0)
{ 
%>

Welcome ADMIN
<h1>Hello, <%=user%> <%=upwd%>!</h1>
<%
session.setAttribute( "uid",uid);
session.setAttribute( "pass",upwd);
session.setAttribute( "user",user);
response.sendRedirect("homepage.jsp");
%>
<% } 
else {
response.sendRedirect("http://localhost:8080/eboliJSP/");
} 
%> 

</body>
</html>