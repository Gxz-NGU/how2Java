package com.gxz.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Category category = new Category();
		category.setId(11);
		category.setName("IjustFeelBlank");
		sqlSession.update("updateCategory",category );
		listAll(sqlSession);
		sqlSession.commit();
		sqlSession.close();
	}
	
	private static void listAll(SqlSession sqlSession) {
		List<Category> list = sqlSession.selectList("listCategory");
		System.out.println("id"+"\t"+"name"+"\t\t"+"price");
		for(Category c:list){
			System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getPrice());
		}
	}

}
