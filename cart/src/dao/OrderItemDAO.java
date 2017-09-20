package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import bean.OrderItem;

public class OrderItemDAO {
	public OrderItemDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","admin");
	}
	
	public void insert(OrderItem oi){
		String sql="insert into orderitem values(null,?,?,?)";
		try(Connection connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			){
			p.setInt(1, oi.getProduct().getId());
			p.setInt(2, oi.getNumber());
			p.setInt(3, oi.getOrder().getId());
			p.execute();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
