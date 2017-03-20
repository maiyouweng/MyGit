package com.lxy.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.lxy.entity.Student;
import com.lxy.mybatis.dao.StudentDao;

public class StudentTest {
	StudentDao dao = null;
	SqlSession session = null;
	
	@Before
	public void setUp() throws Exception {
		System.out.println( "--------setUp-----------" );
		
		String configPath = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	    session = sessionFactory.openSession();
		
		dao = (StudentDao)session.getMapper(StudentDao.class);
	}
	
	

	@Test
	public void query() {
		Student s = dao.queryById("20083001");
		System.out.println( s.getName() );
	}
	
	@Test
	public void insert(){
		Student s = new Student();
		s.setId("20081992");
		s.setName("王五");
		dao.save(s);
		
		session.commit();
	}

	@After
	public void tearDown() throws Exception{
		System.out.println( "--------tearDown-----------" );
		session.commit();
		
		session.close();
	}
}
