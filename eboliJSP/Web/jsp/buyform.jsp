<html>
<head><title>Buy Product</title></head>
<body background="dolphin3.jpg">
<% 
String a=request.getParameter("pid");
session.setAttribute("pid", a);
session.setAttribute("pname", request.getParameter("pname"));
session.setAttribute("pbuynow", request.getParameter("pbuynow"));
%>
<center><form method="post" name="buy" action="buysucces.jsp">
Product Name: <%= session.getAttribute("pname") %>
<br>
<br>
Credit Card:<input type="text" maxlength="4" size="4">-<input type="text" maxlength=4 size="4">-<input type="text" maxlength=4 size="4">-
<input type="text" maxlength=4 size="4">
<br>
<br>
<center><input type="submit" value="Done"></center></form></center>
</body>
</html>