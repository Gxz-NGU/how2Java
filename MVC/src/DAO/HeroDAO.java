package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.coyote.http11.filters.VoidInputFilter;

import com.sun.xml.internal.ws.api.model.WSDLOperationMapping;

import bean.Hero;

public class HeroDAO {
	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "admin");
	}

	public ArrayList<Hero> list() {
		ArrayList<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero";
		try (Connection connection = getConnection(); PreparedStatement p = connection.prepareStatement(sql);) {
			ResultSet resultSet = p.executeQuery();
			while (resultSet.next()) {
				Hero hero = new Hero();
				hero.setId(resultSet.getInt("id"));
				hero.setName(resultSet.getString("name"));
				hero.setDamage(resultSet.getFloat("damage"));
				hero.setHp(resultSet.getInt("hp"));
				heros.add(hero);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}

	public void delete(int id) {
		String sql = "delete from hero where id=" + id;
		try (Connection connection = getConnection(); PreparedStatement p = connection.prepareStatement(sql);) {
			p.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Hero> list(int start, int count) {
		ArrayList<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero limit ?,?";
		try (Connection connection = getConnection(); PreparedStatement p = connection.prepareStatement(sql);) {
			p.setInt(1, start);
			p.setInt(2, count);
			ResultSet resultSet = p.executeQuery();
			while (resultSet.next()) {
				Hero hero = new Hero();
				hero.setId(resultSet.getInt("id"));
				hero.setHp(resultSet.getInt("hp"));
				hero.setDamage(resultSet.getFloat("damage"));
				hero.setName(resultSet.getString("name"));
				heros.add(hero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}

	public int getTotal() {
		String sql = "select count(*) from hero";
		int count=0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())count= resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
