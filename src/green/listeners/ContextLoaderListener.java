package green.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import green.util.DBConnectionPool;

import green.dao.PersonDao;


@WebListener
public class ContextLoaderListener implements ServletContextListener {

	DBConnectionPool connPool;
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ContextLoaderListerner contextDestroyed ok");
    	connPool.closeAll();
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("ContextLoaderListerner contextInitialized ok");
    	try {
			ServletContext sc = event.getServletContext();
		    connPool = new DBConnectionPool(
		    		"com.mysql.cj.jdbc.Driver",
		    		"jdbc:mysql://localhost/jumindb?serverTimezone=Asia/Seoul",
		    		"root",
		    		"1234");
		    System.out.println("DBConnection successfully~!~!!~!~!!~!");
		    PersonDao personDao = new PersonDao();
		    personDao.setConnection(connPool);
			sc.setAttribute("personDao", personDao);
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }
	
}
