<html><body background="dolphin3.jpg">

<%a=request.form("search")
  
   
 
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Provider="Microsoft.Jet.OLEDB.4.0"
Conn.Open(Server.Mappath("OAWdb.mdb"))


Set RS = Server.CreateObject("ADODB.recordset")
RS.Open "select * from proddb where prodname like '%" & a & "%' ",Conn
%>



<center>
<table width="686" border="1">

  <tr>
    <th width="108">Product Name </th>
    
    <th >Description</th>
    <th>Owner Name </th>
    <th >Min Price</th>
    <th>Current Highest Bid</th><th>Buy Now Price</th>
    <th>Bid</th>
    <th>Buy Now</th>
  </tr>


<%WHILE NOT RS.EOF
%>
  <tr>
    <td><%=RS("prodname")%></td>
    
    <td><%=RS("proddesc")%></td>
    <td><%=RS("uname")%></td>
    <td><%=RS("minbprice")%></td>
    <td><%=RS("chbid")%></td><td><%=RS("bnprice")%></td>
     <td><form name="f1" method="post" action="bid1.asp"><center><input type="submit"  name="link" value="<%=RS("prodname")%>"></center></form></td><td><form method="post" name="prodbid1" action="http://localhost/buyform.asp">
<center><input type="submit" name="link1" value="<%=RS("prodname")%>"></center></form>
<%
RS.movenext
wend%>
</table>
</center><%RS.close
 Conn.Close
 %>
</body>
 </html>