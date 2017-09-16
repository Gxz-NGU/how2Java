package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDAO {
	public UserDAO(){
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
	public User getUser(String name,String password){
		User user = null;
		String sql = "select * from user where name=? and password=?";
		try(Connection connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			){
			p.setString(1, name);
			p.setString(2, password);
			ResultSet rSet = p.executeQuery();
			while(rSet.next()){
				user = new User();//这个声明对象的错误 如果不看代码的话感觉自己应该是不会发现了的
				user.setId(rSet.getInt("id"));
				user.setName(rSet.getString("name"));
				user.setPassword(rSet.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
