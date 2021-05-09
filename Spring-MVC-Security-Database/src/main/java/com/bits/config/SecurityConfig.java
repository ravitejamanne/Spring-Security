package com.bits.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{	
	@Autowired
	private DataSource datasourse;

	@Autowired
	PasswordEncoder encoder;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		auth.jdbcAuthentication().dataSource(datasourse)
//			.passwordEncoder(new BCryptPasswordEncoder());
		.passwordEncoder(encoder);
	}


	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("/admin").authenticated()
				.antMatchers("/user").authenticated()
				.antMatchers("/signup").permitAll()
				.antMatchers("/signup-process").permitAll()
				.antMatchers("/customloginpath").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/customloginpath")//.loginProcessingUrl("/process-login")
			.and()
			.httpBasic()
			.and().logout();
		
	}	

	@Bean
	PasswordEncoder passwordencode()
	{
		return new BCryptPasswordEncoder();
//		return NoOpPasswordEncoder.getInstance();
	}
	
}
