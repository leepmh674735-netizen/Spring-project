package com.apress.spring;

import org.springframework.context.ConfigurableApplicationContext;

public class Application {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = new SpringApplication("/META-INF/"
		spring/integration.xml").run(args);"
	    System.out.println(" ");
		System.in.read();
		ctx.close();
		
	}

}
