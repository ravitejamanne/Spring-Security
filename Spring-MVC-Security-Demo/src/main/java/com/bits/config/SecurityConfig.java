package com.bits.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.inMemoryAuthentication()
		.withUser("ravi")
		.password("$2a$10$zyUwEO7/yN/KF3nCT3dg9OCbdVV1ocZ4cZdO11qEWRGkvYdz4dKpC")
		.roles("admin")
		.and()
		.withUser("rk")
		.password("$2a$10$prUXkIe2dKE674Qhays/GOrS6u5301MASnVmUdLaPqgm6/ASQnbW.")
		.roles("admin");
		
		//
	}

	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests()
				.antMatchers("/home").permitAll()
//				.antMatchers("/admin").hasRole("admin")//.authenticated()
				.antMatchers("/admin").authenticated()
				.antMatchers("/user").authenticated()
				.antMatchers("/customloginpath").permitAll()
				.anyRequest().authenticated()
//				.anyRequest().denyAll()
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
