<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.service.ProductService" %>
<html><body background="dolphin3.jpg">

<%

String msg=null;
ProductService pserv = new ProductService();
msg = pserv.buyProduct(Integer.parseInt(session.getAttribute("pid")+""),Integer.parseInt(session.getAttribute("uid")+""),
		session.getAttribute("pname")+"",Double.parseDouble(session.getAttribute("pbuynow")+""));

out.println(msg); 
%>


<br><br>

<form name="formsuces1" action="homepage.jsp" target="_parent">
<center><input type="submit" value="Go to Homepage"></center>
</body>
 </html>