package com.apress.spring;

import java.util.Date;

// 1. 누락된 RabbitMQ AMQP Queue 임포트 추가
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // 2. 올바른 부트 어노테이션 임포트
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.apress.spring.message.Producer;

@EnableScheduling
@SpringBootApplication // 정상적인 스프링 부트 핵심 어노테이션으로 바인딩
public class SpringBootRabbitmqApplication { // 3. 클래스명 오타 수정 (Appliacation -> Application)
	
	public static void main(String[] args) {
		// 4. 실행 메서드 내부의 클래스 명칭도 오타가 수정된 클래스로 일치시켰습니다
		SpringApplication.run(SpringBootRabbitmqApplication.class, args);
	}
	
	@Value("${myqueue}")
	private String queueName; // 관례에 따라 메서드명과 겹치지 않게 변수명 변경 및 접근 제어자 추가
	
	@Bean
	public Queue queue() {
		// 5. org.springframework.amqp.core.Queue 객체를 정상 생성하여 빈으로 등록
		return new Queue(queueName, false);
	}
	
	@Autowired
	private Producer producer;
     
	@Scheduled(fixedDelay = 500L) // 0.5초마다 주기적으로 실행
	public void sendMessages() {
		producer.sendTo(queueName, "안녕하세요, 여러분! 지금 시각은 " + new Date());
	}
}