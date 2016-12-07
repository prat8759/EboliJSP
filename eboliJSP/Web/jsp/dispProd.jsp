<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import= "java.sql.*,com.eboli.common.DBgen;" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Here's a list of the products we offer </title>
</head>

<body background="dolphin3.jpg">
<%

//if(session.getAttribute( "UserName" )){}
int recNo=0;
String sub = request.getParameter("sub");
if(sub==null)  {
	sub="all";System.out.println("NULL");
}
String str1="select * from  productdetails where pstatus!=5;";
String str2="select * from  productdetails where pcat='"+ sub +"' and pstatus!=5; ";
String str3="select fname from  userdetails where uid=?;";
Connection con = null;
try{	
	DBgen.loadOdbcDriver();//load JdbcOdbcDriver class
	
		//System.out.println("System");
	con = DBgen.getMySqlConn("jdbc:mysql://localhost:3306/ebolidb","root","root");
	Statement st = con.createStatement();
	ResultSet rs = null;
	if(sub.equals("") || sub.equals("all") || sub.equals(null))
	{
		rs = st.executeQuery(str1);
	}
	else
	{
		rs = st.executeQuery(str2);
	}
	//PreparedStatement ps = con.prepareStatement(str3);
	
%>
<center>
<table width="686" border=1>

  <tr>
  	<th width="103">Product ID</th> 
    <th width="103">Product Name </th>    
    <th width="135" >Description</th>
    <th width="135" >Prod Code</th>
    <th width="78">Owner Name </th>
    <th width="58" >Min Price</th>
    <th width="81">Current Highest Bid</th>
    <th width="72">Buy Now Price</th>
    <th width="56">Bid</th>
    <th width="51">Buy Now</th>
  </tr>
<%
while(rs.next())
{
%>
  <tr>
  	<td><%=rs.getString("pid") %></td>
    <td height="38" onclick="alert('hi');">
    <%=rs.getString("pname")%></td>   
    <td><%=rs.getString("pdesc") %></td>
    <td><%=rs.getString("pcode") %></td>
    <td><%=rs.getString("pchbidder") %></td>
    <td><%=rs.getString("pminbid") %></td>
    <td><%=rs.getString("pcurbid") %></td>
	<td><%=rs.getString("pbuynow") %></td> 
	 <td><center><a href='bid1.jsp?pid=<%=rs.getString("pid")%>&pname=<%=rs.getString("pname")%>'>
	 <img src=../images/ham.jpg height=30 width="51"></a></center></td>
     <td><center><a href="buyform.jsp?pid=<%=rs.getString("pid")%>&pname=<%=rs.getString("pname")%>&pbuynow=<%=rs.getString("pbuynow")%>">
     <img src=../images/now.jpg width="47" height=30></a>
     </center></td>
  </tr> 
<%
}			
rs.close();
con.close();
	}
	catch(Exception e){
		System.out.println("SQL Error : " + e);
	}
	
%>
</table>
</center>
<%

%>

</body>

</html>
