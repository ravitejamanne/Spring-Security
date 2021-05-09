package com.bits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bits.dao.StudentDao;
import com.bits.pojo.StudentPojo;

@Controller
public class LoginController 
{
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private StudentDao studentdao;

	@GetMapping("/customloginpath")
	public String login()
	{
		System.out.println("from custom login page");
		return "adminlogin";
		
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("signup-pojo") StudentPojo studentpojo)
	{
		System.out.println("from signup page");
		return "signup";
		
	}
	
	@PostMapping("/signup-process")
	public String signpProcess(StudentPojo studentpojo)
	{
		System.out.println(studentpojo);
		
		studentpojo.setPassword(encoder.encode(studentpojo.getPassword()));

		System.out.println(studentpojo);
		studentdao.saveStudent(studentpojo);
		return "redirect:/customloginpath";
		
	}

}
