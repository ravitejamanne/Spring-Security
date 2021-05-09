package com.bits.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDup 
{
	@GetMapping("/wish/{name}")
	public String wish(@PathVariable String name)
	{		
		return "hello "+name;
		
	}

	@GetMapping("/admin")
	public String admin()
	{		
		return "welcome to admin login ";
		
	}
	
	@GetMapping("/user")
	public String user()
	{		
		return "welcome to user login ";
		
	}
	
	@GetMapping("/process-login")
	public String plogin()
	{		
		return "welcome to process login ";
		
	}
}
