<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.dao.EboliDAO" %>
<html><head><title>Password</title></head>
<body background="dolphin3.jpg">

<% 
	String a=request.getParameter("p0");
	String b=request.getParameter("p1");
	String c=request.getParameter("p2");
   out.println(session.getAttribute("pass")+"============"+session.getAttribute("uid"));
	if(session.getAttribute("pass")==null || session.getAttribute("uid")==null)
	{
		out.println("Session has expired");
	}
	else if (!session.getAttribute("pass").equals(a))
	 {
	  	out.println("Old Password is incorrect");
	 } 
	 else if (!b.equals(c))
	{
		 out.println("New Passwords do not match.");
	}  
	 else
  	{	
		 EboliDAO edao = new EboliDAO();
		 if(edao.updUserPwd(Integer.parseInt(session.getAttribute("uid")+""),b)>=1)
		 {
			 out.println("Password changed successfully");
		 	 session.setAttribute("pass",b);
		 }
		 else
		 {
			 out.println("Some Error Occured");
		 }
  	}

 
%></body></html>