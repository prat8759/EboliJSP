package expt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.eboli.common.DBgen;
import com.eboli.dao.EboliDAO;

//import org.apache.log4j.Logger;

public class DataAccessObject {

//private static Logger logger = Logger.getLogger(DataAccessObject.class);
   private static DataSource dataSource;
   private static Object idLock = new Object();

   public static void setDataSource(DataSource dataSource) 
   {
      DataAccessObject.dataSource = dataSource;
      System.out.println("DS just after setting"+dataSource);
   }

   //protected
   public static Connection getConnection() 
   {
      try {
    	  System.out.println("chk dataSource obj in DAO: "+dataSource);
         return dataSource.getConnection();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }

   protected static void close(Statement statement, Connection connection) 
   {
      close(null, statement, connection);
   }

   protected static void close(ResultSet rs, Statement statement,
         Connection connection) 
   {
      try {
         if (rs != null)
            rs.close();
         if (statement != null)
            statement.close();
         if (connection != null)
            connection.close();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }

   protected static Long getUniqueId() {
      ResultSet rs = null;
      PreparedStatement statement = null;
      Connection connection = null;
      try 
      {
    	  System.out.println("Just before getting connection");
         connection = getConnection();
         System.out.println("Just after getting connection");
         synchronized (idLock) 
         {
        	 System.out.println("Entered Sync Block");
            statement = connection.prepareStatement("select userid from login");
            System.out.println("To Get Next Value : "+statement);
            rs = statement.executeQuery();
            rs.first();
            long id = rs.getLong(1);
            /*statement.close();
            statement = connection.prepareStatement("update sequence set next_value = ?");
            statement.setLong(1, id + 1);
            System.out.println("Update To Next Value : "+statement);
            statement.executeUpdate();*/
            statement.close();
            return new Long(id);
         }
      }
      catch (SQLException e) 
      {
         throw new RuntimeException(e);
      }
      finally
      {
         close(rs, statement, connection);
      }
   }
   
   
   public static void main(String args[]) throws ClassNotFoundException, SQLException
   {
	  // System.out.println(getUniqueId());
	   //DBgen.getMySqlConn();
	   System.out.println((new EboliDAO()).getUserId("user1"));
	   
   }
}
