<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.service.AccountProcService" %>
<html><body background="world.jpg">

<%
String name1 = request.getParameter("name1");
String name2 = request.getParameter("name2");
String user = request.getParameter("user");
String email = request.getParameter("email");
String add = request.getParameter("add");
String cont = request.getParameter("cont");
String age = request.getParameter("age");
String pass = request.getParameter("pass");
String pass1 = request.getParameter("pass1");

if(Integer.parseInt(age)<18)
{
	out.println("Sorry! you cannot become a member of e-Boli as your age is under 18");
}
else if(!pass.equals(pass1))
{
	out.println("Passwords do not match");
}
else
{
	AccountProcService aps = new AccountProcService();
	aps.registerUser(user,pass,name1,name2,add);
}
  
  
%>


Congratulations! You are now a proud member of e-Boli .
<br><br>
Your account details:<br>
<%out.println("Name :- "+name1+" "+name2);%><br><br>
<%out.println("Userame :- "+user);%><br><br>
<%out.println("Email Id :- "+email);%><br><br>
<%out.println("City :- "+add);%><br><br>
<%out.println("Pin Code :- "+cont);%><br><br>
<form name="formsuces" action="homepage.jsp">
<center><input type="submit" value="Go to Homepage"></center>
 </body>
 </html>