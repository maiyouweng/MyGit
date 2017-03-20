package com.lxy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;

import com.lxy.entity.Student;
import com.lxy.mybatis.dao.StudentDao;

public class MyTest {
	public static void main(String[] args) throws IOException {
		String configPath = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		
		StudentDao dao = (StudentDao)session.getMapper(StudentDao.class);
		
		Student s = new Student();
		s.setId("20082997");
		s.setName("张三");
		dao.save(s);
		
		session.commit();
		System.out.println("save finish");
		
		Student ss = dao.queryById("20082997");
		System.out.println( ss.getName() );
		
		ApplicationContext app;
		
		session.close();
		
	}
}
