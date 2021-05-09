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
	
	@GetMapping("/process-login")
	public String plogin()
	{		
		return "welcome to process login ";
		
	}
}
