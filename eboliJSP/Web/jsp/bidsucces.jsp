<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.service.ProductService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body background="dolphin3.jpg">
 <% 
 String msg=null;
 ProductService pserv = new ProductService();
 msg = pserv.bidForProduct(Integer.parseInt(session.getAttribute("pid")+""), Double.parseDouble(request.getParameter("pnewbid")), Integer.parseInt(session.getAttribute("uid")+""));
 
out.println(msg);
 
%>
<br><br><br><br><br><br>
<a href="bid1.jsp?pid=<%=session.getAttribute("pid")%>&pname=<%=session.getAttribute("pname")%>" tarfet="frame3">Bid Again</a>
<br><br>
<a href="homepage.jsp" target="_parent">Go To Homepage</a>
</body>
