package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

@SuppressWarnings("serial")
public class OrderItemDeleteServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int pid = Integer.parseInt(request.getParameter("pid"));
		@SuppressWarnings("unchecked")
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		List<OrderItem> deleteOis = new ArrayList<OrderItem>();
		for(OrderItem oi:ois){
			if(oi.getProduct().getId() == pid){
				deleteOis.add(oi);
				break;
			}
		}
		ois.removeAll(deleteOis);
		response.sendRedirect("listOrderItem");
	}
}
