package com.lxy.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.lxy.entity.Student;

public interface StudentDao {
	
	@Select("SELECT * FROM STUDENT WHERE ID = #{id}")
	public Student queryById(String id);
	
	public void save(Student s);
}
