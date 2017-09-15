package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {
	public ProductDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","admin");
	}
	
	public ArrayList<Product> listProduct(){
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from product order by id desc";
		try(Connection connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			){
			ResultSet rSet = p.executeQuery();
			while(rSet.next()){
				Product product = new Product();
				product.setId(rSet.getInt(1));
				product.setName(rSet.getString("name"));
				product.setPrice(rSet.getFloat("price"));
				products.add(product);
			}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return products;
	}
}
