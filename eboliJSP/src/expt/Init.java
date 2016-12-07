package expt;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

//import org.apache.log4j.Logger;

import expt.DataAccessObject;

public class Init implements ServletContextListener {

//    private Logger logger = Logger.getLogger(this.getClass());
    
    public void contextDestroyed(ServletContextEvent sce) {
    	
    	System.out.println("contextDestroyed");
    }
    
    private void contextInitialized2(ServletContext servletContext)
    throws Exception {
       InitialContext enc = new InitialContext();       
       //DataSource dataSource = (DataSource) enc.lookup("java:comp/env/datasource2");
       DataSource dataSource = (DataSource) enc.lookup("java:comp/env/jdbc/ebolids");//as defined in server.xml
       System.out.println("chk dataSource obj in Init: "+dataSource);
       //org.apache.tomcat.dbcp.dbcp.BasicDataSource@1f6ef9f
       DataAccessObject.setDataSource(dataSource);
       System.out.println("Datasource Set in Init Class");
       //System.out.println(DataAccessObject.getUniqueId());
    }

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        try {
           contextInitialized2(servletContext);
        }
        catch (Exception e)
        {
        	System.out.println("Initialization failed."+ e);
           throw new RuntimeException(e);
        }
        System.out.println("Initialization succeeded.");
    }
}