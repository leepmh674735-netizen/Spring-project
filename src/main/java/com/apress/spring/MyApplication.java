package com.apress.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public MyApplication implements CommandLineRunner {
	
	public void run(String...args) {
		//SpringApplication.run( ...  )직후에 실행됨
		// 뭔가 수행하겠지?
	}
	
	public static void main(String[] args)throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

}

@Bean
public CommandLineRunner runner() {
	return new CommandLineRunner() {
		public void run(String  .. . args) {
			// 프로세스 실행
		}
	};
}
	
@Bean
public CommandLineRunner runner(Repository repo) {
	return args -> {
		// 프로세스 실행
	};
}

@Bean
InitializingBean saveDate(Repository repo) {
	return () -> {
		//DB 데이터 삽입
	};
}

