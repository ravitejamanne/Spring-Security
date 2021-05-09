package com.bits.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bits.pojo.StudentPojo;

@Repository
public class StudentDaoImpl implements StudentDao 
{
	@Autowired
	JdbcTemplate templete;

	@Override
	public void saveStudent(StudentPojo studentpojo) 
	{
		System.out.println("from dao: "+studentpojo);
		String query="insert into users values(?,?,?)";
		templete.update(query, studentpojo.getUsername(), studentpojo.getPassword(), studentpojo.getId());
//		templete.update("insert into users values(\"raviteja\",\"manne\",1)");
		
		String query2="insert into authorities values(?,?)";
		templete.update(query2, studentpojo.getUsername(), "user");
	}

}
