package com.bits.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		Class configs[]=new Class[] {AppConfig.class};

		return configs;
	}

	@Override
	protected String[] getServletMappings() 
	{
		String mappings[]=new String[] {"/"};

		return mappings;
	}

}
