<html><body background="dolphin3.jpg">

<%a=request.form("pname")
  
   
 
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Provider="Microsoft.Jet.OLEDB.4.0"
Conn.Open(Server.Mappath("OAWdb.mdb"))


Set RS = Server.CreateObject("ADODB.recordset")
RS.Open "select * from proddb where prodname='" & a & "' ",Conn
Session("prod")=request.form("link")
%>



<br>
<%response.write("Product :- ")%><%=Session("prod")%><br><br>
<%response.write("Category :- ")%><%=RS("prodcat")%><br><br>
<%response.write("Description:- ")%><%=RS("proddesc")%><br><br>
<%response.write("Minimum Price :- Rs.")%><%=RS("minbprice")%><br><br>
<%response.write("Current Highest bid :- Rs.")%><%=RS("chbid")%><br><br>
<%response.write("Buy NowPrice :- Rs.")%><%=RS("bnprice")%><br><br>
<%response.write("Owner username :- ")%><%=RS("uname")%>

<form name="prodbid1" action="bid1.asp">
<center><input type="submit" value="Bid for <%=RS("prodname")%>"></center></form>
<form name="prodbid1" action="buyform.asp">
<center><input type="submit" value="Buy <%=RS("prodname")%>"></center></form>
<%RS.close
 Conn.Close
 %>
</body>
 </html>