package myclass.mvc.dao;

import myclass.mvc.us.User;

public interface UserDao {
	public boolean trylogin(User user) throws Exception;
}
