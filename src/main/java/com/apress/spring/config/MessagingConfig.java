package com.apress.spring.config;

// 1. 잘못된 PostgreSQL 관련 임포트를 JMS 표준 ConnectionFactory로 수정
import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.apress.spring.message.Consumer; // 2. 이전 단계에서 만든 Consumer 클래스 임포트 가정

@Configuration
public class MessagingConfig {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Value("${myqueue}")
	private String queue;
	
	@Bean
	public DefaultMessageListenerContainer messageListener() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		
		// 3. 잘못 바인딩된 메서드들을 올바른 스프링 JMS API 명세로 수정
		container.setConnectionFactory(this.connectionFactory); // 커넥션 팩토리 주입
		container.setDestinationName(queue);                    // 목적지(큐) 이름 지정
		container.setMessageListener(new Consumer());           // 메시지를 처리할 리스너 등록
				
		return container;
	}
}