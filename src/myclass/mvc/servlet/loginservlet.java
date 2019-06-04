package myclass.mvc.servlet;

import myclass.mvc.us.User;
import myclass.mvc.dao.UserDao;
import myclass.mvc.dao.UserDaoImpl;
import myclass.mvc.db.DBConnection;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class loginservlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "login.jsp";	
		String userid = request.getParameter("userid");	
		String userpass = request.getParameter("userpass");	
		List<String> info = new ArrayList<String>();
		if(userid==null || "".equals(userid)){	
			info.add("用户名不能为空！");
		}
		if(userpass==null || "".equals(userpass)){	
			info.add("密码不能为空！");
		}	
		if(info.size()==0){	
			User user = new User();	
			user.setUserid(userid);		
			user.setPassword(userpass);	
			try {
				
				DBConnection dbc = null;
				try {
					dbc = new DBConnection();	
				} catch (Exception e) {
					e.printStackTrace();
				}
				UserDaoImpl u = null;
				u = new UserDaoImpl(dbc.getConnection());
				
				if(u.trylogin(user)){	
					info.add("用户登录成功，身份为： "+ user.getT_or_s());
					if("学生".equals(user.getT_or_s())) {
						path="student.jsp";
					}
					else {
						path="teacher.jsp";
					}
				}else{
					info.add("用户登录失败，错误的用户名或密码！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("info", info);	
		request.getRequestDispatcher(path).forward(request, response);	
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);	
	}
}
