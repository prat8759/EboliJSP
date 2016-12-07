package com.eboli.common;
import java.sql.*;

public class DBgen {
	/*------------------------------ODBC---------------------------------*/
	public static void loadOdbcDriver() throws ClassNotFoundException
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}	
	public static Connection getOdbcConn(String dsn, String uname, String pwd) throws SQLException{
	Connection con = DriverManager.getConnection("jdbc:odbc:"+dsn,uname,pwd);
	return con;
	}
	
	/*------------------------------Oracle---------------------------------*/
	public static void loadOracleDriver() throws ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}	
	public static Connection getOracleConn() throws SQLException{
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","apr11","apr11");
	return con;
	}
	/*------------------------------MySQL---------------------------------*/
	public static void loadMySqlDriver() throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public static Connection getMySqlConn() throws SQLException, ClassNotFoundException{
		loadMySqlDriver();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebolidb","root","root");
		return con;
	}
	public static Connection getMySqlConn(String url, String uname, String pwd) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebolidb","root","root");
		return con;
	}
	
	
}
/*
forName("oracle.jdbc.driver.OracleDriver")
getConnection("jdbc:oracle:thin:@localhost:1521:XE","apr11","apr11")

forName("sun.jdbc.odbc.JdbcOdbcDriver")
getConnection("jdbc:odbc:Webstats","","")

//"sun.jdbc.odbc.JdbcOdbcDriver"
//"jdbc:odbc:MyDsn1","p2","p2"

forName("com.mysql.jdbc.Driver")
getConnection("jdbc:mysql://localhost:3306","","")
*/