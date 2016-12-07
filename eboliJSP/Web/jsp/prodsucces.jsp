<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.service.ProductService,com.eboli.beans.ProductDetailsBean" %>
<html><body background="dolphin3.jpg">

<%
String a=request.getParameter("name");
String b=request.getParameter("desc");
String d=request.getParameter("cat");
String e=request.getParameter("price");
String f=request.getParameter("bprice");

ProductDetailsBean pdb = new ProductDetailsBean();
pdb.setPname(a);
pdb.setPdesc(b);
pdb.setPcat(d);
pdb.setPcode(d.substring(0,3));
pdb.setPminbid(Double.parseDouble(e));
pdb.setPcurbid(Double.parseDouble(f));
pdb.setPbuynow(Double.parseDouble(f));
pdb.setPstatus(1);
   
ProductService pserv = new ProductService();
String msg = pserv.addProduct(pdb,Integer.parseInt(session.getAttribute("uid")+""));
if(msg.equals("Product created and saved sucessfully"))
{
%>


Congratulations! Your product has been sucessfully added to e-Boli .
<br><br>
Your product details:<br>
<%out.println("Product Name :- "+a);%><br><br>
<%out.println("Category :- "+b);%><br><br>
<%out.println("Description:- "+d);%><br><br>
<%out.println("Minimum Price :- "+e);%><br><br>
<%out.println("Buy Now Price :- "+f);%><br><br>
<% }else { %>
<% 
	out.println(msg);
}%>
<form name="formsuces1" action="homepage.jsp" target="_parent">
<center><input type="submit" value="Go to Homepage"></center>
</body>
 </html>