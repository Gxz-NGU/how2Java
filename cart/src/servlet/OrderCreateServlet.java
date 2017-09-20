package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

public class OrderCreateServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("login");
			return;
		}
		Order o = new Order();
		o.setUser(user);
		try {
			new OrderDAO().insert(o);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<OrderItem> ois = (ArrayList<OrderItem>)request.getSession().getAttribute("ois");
		for(OrderItem oi:ois){
			oi.setOrder(o);
			try {
				new OrderItemDAO().insert(oi);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ois.clear();
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("创建订单成功！");
	}
}
