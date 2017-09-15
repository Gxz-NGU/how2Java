package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserDAO userDAO = new UserDAO();
		String name =(String) request.getAttribute("name");
		String password = (String) request.getAttribute("password");
		User user = userDAO.getUser(name, password);
		if(null == user) response.sendRedirect("login.jsp");
		else
			try {
				request.getRequestDispatcher("listproduct.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("是这里抛出的sql异常");
			}
	}
}
