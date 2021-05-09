package com.bits.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.bits")
public class AppConfig 
{
	
	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

	@Bean
	public JdbcTemplate setTemplete()
	{
		
		JdbcTemplate templete = new JdbcTemplate();
		templete.setDataSource(datasourse());
		
		return templete;
	}
	
	
	@Bean
	public DataSource datasourse()
	{
		DriverManagerDataSource dmds  = new DriverManagerDataSource();
		dmds.setUrl("jdbc:mysql://localhost:3306/pro");
		dmds.setUsername("root");
		dmds.setPassword("Ravi@151");
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dmds;
	}
}
