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
			repo.save(new Journal("forget", "weird", "05/21/2026"));
			repo.save(new Journal("pledge", "trigger", "05/22/2026"));
			repo.save(new Journal("capital", "favorite", "05/23/2026"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}