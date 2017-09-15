package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class ProductListServlet extends HttpServlet{
	protected void  service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products = productDAO.listProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("listproduct.jsp").forward(request, response);
	}
}
