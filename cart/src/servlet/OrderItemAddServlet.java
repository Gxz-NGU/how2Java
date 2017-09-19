package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

//addOrderItem需要在web.xml中写上这么一句话url-pattern

public class OrderItemAddServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int number = Integer.parseInt(request.getParameter("number"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProductDAO pDao = new ProductDAO();
		Product product =  pDao.getProduct(pid);
		OrderItem orderItem = new OrderItem();
		orderItem.setNumber(number);
		orderItem.setProduct(product);
		List<OrderItem> ois = (List<OrderItem>)request.getSession().getAttribute("ois");
		if(null== ois){
			ois = new ArrayList<OrderItem>();
			request.getSession().setAttribute("ois", ois);
		}
		for(OrderItem oi:ois){
			if(oi.getProduct().getId() == orderItem.getProduct().getId()){
				
			}
		}
		ois.add(orderItem);
		response.sendRedirect("/cart/listOrderItem");
	}
	
}
