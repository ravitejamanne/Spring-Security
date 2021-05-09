package com.bits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{

	@GetMapping("/customloginpath")
	public String login()
	{
		System.out.println("from custom login page");
		return "adminlogin";
		
	}
	
	

}
