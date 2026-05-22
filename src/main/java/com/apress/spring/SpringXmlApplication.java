package com.apress.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;

import com.winter.crucial.SpringBootApplication;

@ImportResource({"META_INF/spring/services-context.xml", 
	"META-INF/spring/repositories-context.xml"})
@SpringBootApplication
public class SpringXmlApplication {
	
	@Autowired
	TaskRepository task;
	
	@Autowired
	ServiceFacade service;

	
}
