package com.qyubix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication @Configuration
public class QyubixApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(QyubixApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/public/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/images/");
		System.out.println("file:"+System.getProperty("user.dir")+"/images/");
	}
}
