package com.apress.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.domain.Journal;
import com.apress.spring.domain.JournalRepository;

@SpringBootApplication
public class SpringBootJournalApplication {
	
	@Bean
	InitializingBean saveData(JournalRepository repo) {
		return () -> {
			repo.save(new Journal("forget","weird","gain"));
			repo.save(new Journal("pledge","trigger", "ultumatum"));
			repo.save(new Journal("capital", "favorite","killer"))
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}