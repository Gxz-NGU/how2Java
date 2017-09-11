package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HerolistServlet extends HttpServlet{
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			int start =0;
			if(request.getParameter("start")!=null)
				start = Integer.parseInt(request.getParameter("start"));
			int count =5;
			int next = start+count;
			int pre = start-count;
			HeroDAO heroDAO= new HeroDAO();
			int total = heroDAO.getTotal();
			int last=0;
			if(0==total%count)
				last = total-count;
			else last = total - total%count;
			pre=pre<0?0:pre;
			next = next>last?last:next;
			
			ArrayList<Hero> heros = heroDAO.list(start, count);
			request.setAttribute("heros", heros);
			request.setAttribute("next", next);
			request.setAttribute("pre", pre);
			request.setAttribute("last", last);
			request.getRequestDispatcher("content/herolist.jsp").forward(request, response);
		}
	
}