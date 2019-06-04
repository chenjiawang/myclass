package myclass.mvc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/system?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "5313";
	private Connection conn = null;
	
	public DBConnection() throws Exception {
		try {
			Class.forName(DBDRIVER); // 加载驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // 连接数据库
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection() {	
		return this.conn;
	}
	
	public void close() throws Exception {	
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
