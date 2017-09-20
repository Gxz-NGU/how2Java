package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import bean.Order;

public class OrderDAO {
	public OrderDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","admin");
	}
	public void insert(Order o){
		String sql = "insert into order_ values(null,?)";
		try(Connection connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			){
			p.setInt(1, o.getUser().getId());
			p.execute();
			ResultSet resultSet = p.getGeneratedKeys();
			if(resultSet.next()){
				o.setId(resultSet.getInt(1));
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
