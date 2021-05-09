package com.bits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController 
{
	
	@RequestMapping("/home")
	public String show()
	{
		return "home";
		
	}
	
	@GetMapping("/admin")
	public String admin()
	{		
		return "admin-datapage";
		
	}
	
	@GetMapping("/user")
	public String user()
	{		
		return "user-datapage";
		
	}

}
