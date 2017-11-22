package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * mysql 数据库连接类 
 * @author Administrator
 *
 */
public class BaseConnection {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mldn";
	private static final String USER="root";
	private static final String PASSWORD="mysqladmin";
	private static ThreadLocal<Connection> local=new ThreadLocal<>();
	private static Connection connDate() {
		Connection conn=null;
		if(conn==null) {
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
		return conn;
	}
	
	public static Connection getConnection() {
		Connection conn=local.get();
		if(conn==null) {
			conn=connDate();
			local.set(conn);
		}
		
		return conn;
	}
	
	public static void close() {
		Connection conn=local.get();
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		local.remove();
	}

}

