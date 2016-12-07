<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.dao.EboliDAO" %>
<html>
<head>
<script>
var v="xyz";
</script>
</head>
<body>
<% String st="<script>document.writeln(v)</script>";
out.println("value="+st); 
java.util.Date today = new java.util.Date();
java.sql.Date d = new java.sql.Date(today.getTime());
out.println("today="+d); 
%>
</body>
</html>