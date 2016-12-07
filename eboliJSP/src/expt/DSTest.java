package expt;
//http://www.mkyong.com/tomcat/how-to-configure-mysql-datasource-in-tomcat-6/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DSTest {

	private static DataSource ds;
	
	public DSTest(){
		  try {
			//Context ctx = new InitialContext();
			//javax.naming.NoInitialContextException: Need to specify class name in environment or system property, 
			//or as an applet parameter, or in an application resource file:  java.naming.factory.initial			
			//ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ebolids");
			  
			  Context initContext  = new InitialContext();
	            Context envContext  = (Context)initContext.lookup("java:/comp/env");
	            ds = (DataSource)envContext.lookup("jdbc/testdb");
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
		}
	 
		public static void testDS() {	 
		  //get database connection
			
			ResultSet rs = null;
		    PreparedStatement statement = null;	
			try
			{
			    Connection con = ds.getConnection();
			    statement = con.prepareStatement("select userid from login");
	            System.out.println("To Get Next Value : "+statement);
	            rs = statement.executeQuery();
	            rs.first();
	            long id = rs.getLong(1);
	          
	            statement.close();
			}catch(SQLException se)
			{
				System.out.println("Exception: "+se);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DSTest();
		System.out.println(ds);
		testDS();
	}

}
