<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.bidform{
margin-top : 100px;
text-align : "center";
}
</style>
</head>

<body background="dolphin3.jpg">
<% 
String a=request.getParameter("pid");
session.setAttribute("pid", a);
session.setAttribute("pname", request.getParameter("pname"));
%>
<div class="bidform">
<fieldset>
<center><h2>BID FORM</h2></center>
<div stlye ={ text-align:"center";}>
<form method="post" name="form3" action="bidsucces.jsp">

<br><br>
Prod Name: <%= session.getAttribute("pname") %> 
<br><br>
Your Bid: &nbsp;&nbsp;&nbsp;<input type="text" name="pnewbid">
<br><br>
<center>
<input type="submit" value="submit" >
<input type="reset" ></center>
</form>
</div>
</fieldset></div>
</body>
</html> 