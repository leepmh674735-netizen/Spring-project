package com.winter.crucial.grovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Grab("spring-boot-web-starter")
@EnableAutoConfiguration(exclude=[ActiveMQAutiContigureatin.class])
@RestController
public class WeApp {
	@RequestMapping("/")
	String greetings() {
		"leisure!"
	}
	public static void main(String[] args) {
		SpringApplication.run(WeApp.class, args)
	}
}