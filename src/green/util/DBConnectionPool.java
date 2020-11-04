package green.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	String url;
	String username;
	String  password;
	ArrayList<Connection> connList = new ArrayList<Connection>();
	
	public DBConnectionPool(String driver, String url, String username
			, String password) throws Exception{
		System.out.println("DBConnectionPool DBConnectionPool ok");
		this.url=url;
		this.password =password;
		this.username =username;
		Class.forName(driver);
	}
	
	//서블릿에서 Connection을 얻으려고 호출함 
	public Connection getConnection() throws Exception{
		System.out.println("DBConnectionPool getConnection ok");
		if(connList.size()>0) {
			Connection conn = connList.remove(0);
			if(conn.isValid(10)) {
				return conn;
			}
		}
		return DriverManager.getConnection(url,username, password);
	}
	
	public void returnConnection(Connection conn) throws Exception{
		System.out.println("DBConnectionPool returnConnection ok");
		connList.add(conn);
	}
	
	public void closeAll() {
		System.out.println("DBConnectionPool closeAll ok");
		for(Connection conn :connList) {
			try{conn.close();} catch (Exception e) {}
		}
	}
}
