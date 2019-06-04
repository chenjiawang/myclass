package myclass.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myclass.mvc.dao.UserDao;
import myclass.mvc.us.User;


public class UserDaoImpl implements UserDao{
	private Connection c = null;
	private PreparedStatement p =null;
	
	public UserDaoImpl(Connection c) {
		this.c = c;
	}
	
	public boolean trylogin(User user) throws Exception{
		boolean flag = false;
		String sql = "select name from user where userid=? and password=?";
		
		try {
			p = c.prepareStatement(sql);
			p.setString(1, user.getUserid());	
			p.setString(2, user.getPassword());
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				user.setT_or_s(rs.getString(1)); 
				flag = true; 					
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (p != null) {
				try {
					p.close();	
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		return flag;
	}
}
