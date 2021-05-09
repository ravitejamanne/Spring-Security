package com.bits.dao;

import org.springframework.context.annotation.Bean;

import com.bits.pojo.StudentPojo;

public interface StudentDao 
{
	@Bean
	void saveStudent(StudentPojo studentpojo);

}
