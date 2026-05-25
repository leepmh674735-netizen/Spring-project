package com.apress.spring.message;

// 1. 잘못된 Log4j/MyBatis 라이브러리를 스프링 표준(JMS 및 SLF4J)으로 전면 교체
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 2. 클래스명 오타 수정 (Consummer -> Consumer)
public class Consumer implements MessageListener {
	
	// 3. 로거 생성 방식 및 클래스명 매칭 수정
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Override
	public void onMessage(Message message) { // 4. 파라미터 오타 수정 (messge -> message)
		try {
			// 5. 일반적인 JMS TextMessage 처리 방식으로 안전하게 다운캐스팅 후 본문 추출
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				log.info("소비기> " + textMessage.getText());
			} else {
				log.info("소비기> 지원하지 않는 메시지 형식입니다: " + message.getJMSType());
			}
		} catch (JMSException ex) {
			log.error("메시지 처리 중 에러 발생", ex); // e.printStackTrace() 대신 로거 활용
		}
	}
}