package com.winter.crucial.groovy;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Grab("spring-boot-starter-web")
@EnableAutoConfiguration(exclude = [ActiveMQAutoConfiguration.class])
@RestController
public class WebApp {

    @RequestMapping("/")
    String greetings() {
        return "leisure!"
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args)
    }
}