package com.eboli.common;

import java.sql.*;

public class Validations {

	public static boolean LoginFrmDB(String frm_uid, String frm_pwd) throws Exception
	{
		System.out.println("Datasource Inside LoginFrmDB: "+expt.DataAccessObject.getConnection());
		boolean b = RetrieveFrmDB(frm_uid,frm_pwd);
		return b;
	}
	
	private static boolean RetrieveFrmDB(String frm_uid, String frm_pwd) throws Exception
	{
		int recNo=0;
		 
		try{	
			//System.out.println("System");
			DBgen.loadOdbcDriver();//load JdbcOdbcDriver class
			
			try{
				//System.out.println("System");
			Connection con = DBgen.getMySqlConn();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login");
			
				while(rs.next())
				{
					//System.out.println("System");
					String db_uid = rs.getString("uname");
					String db_pwd = rs.getString("upwd");
					System.out.print("Record " + ++recNo + " is ");
					System.out.println(db_uid + " ---  " + db_pwd);				
					if((frm_uid.equals(db_uid)) && (frm_pwd.equals(db_pwd)))
						{
						//System.out.println(" Here ---  ");
							return true;
						}
				}			
			}
			catch(Exception e){
				System.out.println("SQL Error : " + e);
			}
		}	
		catch(Exception e){
			System.out.println("Connection Error : " + e);
		}		
		return false;
	}
	

public static void main(String args[]) throws Exception
{
	boolean b = LoginFrmDB("111111","111111");	
	System.out.println(b);
	boolean b1 = LoginFrmDB("101","pwd");	
	System.out.println(b1);
}
}