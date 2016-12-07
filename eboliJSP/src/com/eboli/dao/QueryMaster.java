package com.eboli.dao;

public class QueryMaster {
	
	public static final String getUlogdetFromUnameQry = "select * from login where uname=? ;";
	
	public static final String isUnamePresQry = "select count(userid) 'count' from login where uname=? ;";
	
	public static final String getProdIdFromPnamePcatQry = "select pid from productdetails where pname=? and pcat=? ;";
	
	public static final String getAllProductsQry = "select * from productdetails where pstatus!=5";							//D
	
	public static final String getCatWiseProdDetailsQry = "select * from productdetails where pcat=? and pstatus!=5;";	//D
	
	public static final String getProdDetFromPidQry = "select * from productdetails where pid=? and pstatus!=5;";			//D
	
	
	public static final String getCurBidForProdQry = "select pcurbid,pminbid from productdetails where pid=? ;";	//temp not used
	
	public static final String updCurBidForProdQry = "update productdetails set pcurbid=?,pchbidder=? where pid=? ;";
	
	public static final String updProdDetQry = "update productdetails set pcode=?,pname=?,pdesc=?, " +
			"pcat=?,pminbid=?,pincurbid=?,pbuynow=?,pstatus=? where pid=? ;";
	
	public static final String updProdStatusQry = "update productdetails set pstatus=? where pid=? ;";
	
	public static final String delProdQry = "delete from productdetails where pid=? ;";	
			
	public static final String	insertProdDetQry = "insert into productdetails(pcode,pname,pdesc,pcat,pminbid,pcurbid,pbuynow,pstatus,pchbidder) " +
			"values(?,?,?,?,?,?,?,?,?); ";	
	
	public static final String getUserDetQry = "select * from userdetails where userid=?";
	
	public static final String updUserDetQry = "update userdetails set fname=?, lname=?, mname=?, " +
			"addr1=?, addr2=?, city=?, state=? pincode=?, email=? where uid=?";
	
	public static final String getUserPwdFromUidQry = "select upwd  from login where userid=? ;";
	
	public static final String updUserPwdQry = "UPDATE login SET upwd =?  WHERE userid =? ;";
	
	public static final String insTxnDetQry = "insert into transactiondetails(uid,pid," +
			"tamt,ttime,tstatus,ttype) values (?,?,?,?,?,?);";
	
	public static final String updTxnDetQry = "update transactiondetails SET tamt=?,ttime=?, " +
			"tstatus=?,ttype=? where uid=? and pid=?;";
	
	public static final String getTxnIdQry = "select tid from transactiondetails where uid=? and pid=? ;";
		
	public static final String getAllLoginDetails = "select * from login";//17
	/*
	EBOLIDAO has 4 queries
	
	dispProd.jsp
	String str1="select * from  productdetails";
	String str2="select * from  productdetails where pcat='"+ sub +"' ";
	
	Validation.java
	"select * from login"
	
	
	bidsucess.jsp
	 RS.Open "select chbid from proddb where prodname = '" & Session("prod") &"' ",Conn
	 Conn.execute  " UPDATE proddb SET chbid =' " & e & "', chbidder= '" & Session("user") & "'  WHERE prodname = '" & Session("prod") & "' ;  "

	buysucess.jsp
	delete * from proddb where prodname='"& Session("prod") &"'
	
	prodbid.jsp
	RS.Open "select * from proddb where prodname='" & a & "' ",Conn
	
	prodsucces.jsp
	insert into proddb values('" & a & "','" & b & "','" & Session("user") & "','" & e & "','" & d & "','" & e & "','"&  c &"','"&  f &"')"
	
	
	
	
	prodsearch.jsp
	RS.Open "select * from proddb where prodname like '%" & a & "%' ",Conn
	
	*/
	
	
	/*
	http://techmyguru.com/JDBC/index.php?section=5 
	Syntax - Connection con=DriverManager.getConnection("URL","userid","password");
	
	Type1
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("jdbc:odbc:datasource1");
	
	Type4
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");
	
	SELECT	ResultSet res = ps.executeQuery();
	INSERT	int i = ps.executeUpdate(); 
	UPDATE	int i = ps.executeUpdate();
	DELETE	int i = ps.executeUpdate();
	 */ 
	
}
