package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winter.crucial.SpringBootApplication;

@RestController
@SpringBootApplication
public class SimpleWebSpringBootApplication {
	
	@RequestMapping("/showMessage.html")
	public String index() {
		return "스프링 부트 시작!";
	}
	
   public static void main(String[] args) {
	SpringApplication.run(SimpleWebSpringBootApplication, class, args);
	
   }

}
