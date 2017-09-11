package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class DeleteHeroServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		HeroDAO heroDAO = new HeroDAO();
		heroDAO.delete(id);
	
		response.sendRedirect("herolist");
	}
	
}