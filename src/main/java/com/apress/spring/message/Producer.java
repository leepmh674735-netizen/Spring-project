package com.apress.spring.message;

// 1. 로깅 라이브러리를 스프링/SLF4J 표준으로 변경
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class Producer {
	
	// 2. 클래스 매칭 오타 수정 및 세미콜론(;) 추가
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	// 3. 타입과 변수명을 명확히 지정하여 필드 선언
	private final JmsTemplate jmsTemplate;
	
	// 4. 생성자 주입 방식 유지 (스프링 4.3 이후부터는 생성자가 하나면 @Autowired 생략 가능)
	public Producer(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendTo(String queue, String message) {
		this.jmsTemplate.convertAndSend(queue, message);
		// 5. 로거 이름(log) 및 로깅 방식 정돈
		log.info("생산기> 메시지 전송: {}", message);
	}
}