package com.apress.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:applicationContext.xml")
@Configuration
public class SimpleConfiguation {
	
	@Autowired
	connection connnection;  // applicationContext.xml
   
	@Bean
	Database getDatebaseConnection() {
		return connection.getDBConnection();
	}
}
