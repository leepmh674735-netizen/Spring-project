package com.apress.spring;

import java.lang.System.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.winter.crucial.SpringBootApplication;

@SpringBootApplication
public class SimpleJdbcAppApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(
		SimpleJdbcAppApplication.class);
		
		@Autowired
		JournalService service;
		
		public static void main(String[] args) {
			SpringApplication.run(SimpleJdbcApplication.class, args);
	}
		
		@Override
		public void run(String ...strings arg0)throws Exception {
			log.info("@@  데이터 생성....");
			service.insertData();
			log.info("@@ findAll() 호출...");
			service.finalAll().forEach(entry -> log.info(entry.toString()));
		}
}