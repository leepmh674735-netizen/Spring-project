package sample.spring.chapter04.bankapp.service; // 1. 오타 수정: chaptor04 -> chapter04

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import sample.spring.chapter01.FixedDepositDao; // 2. 오타 수정: chaptor01 -> chapter01
import sample.spring.chapter04.bankapp.domain.FixedDepositDetails; // 누락된 도메인 임포트 가정
import sample.spring.chapter04.bankapp.event.EventSender; // 누락된 이벤트센더 임포트 가정

public class FixedDepositServiceImpl implements FixedDepositService {
	
	// 3. 표준 SLF4J 로거 선언 (기존 java.lang.System.Logger 오류 교정)
	private static final Logger logger = LoggerFactory.getLogger(FixedDepositServiceImpl.class);
	
	private FixedDepositDao fixedDepositDao;
	private EventSender eventSender;
	
	// 생성자: 외부 설정을 읽어와 리플렉션으로 EventSender 동적 생성
	public FixedDepositServiceImpl(String configFile) throws Exception {
		ClassPathResource configProperties = new ClassPathResource(configFile);
		
		if (configProperties.exists()) {
			// try-with-resources 구문으로 자원(InputStream) 자동 해제 처리로 안전성 확보
			try (InputStream inStream = configProperties.getInputStream()) {
				Properties properties = new Properties();
				properties.load(inStream);
				
				// 4. 대소문자 및 오타 수정 (Constants 클래스명이 대문자로 시작한다고 가정)
				String eventSenderClassString = properties.getProperty(Constants.EVENT_SENDER_CLASS_PROPERTY);
				
				if (eventSenderClassString != null) {
					// 5. 철자 오타 수정 (enent -> event, eventSenderr -> eventSender)
					Class<?> eventSenderClass = Class.forName(eventSenderClassString);
					this.eventSender = (EventSender) eventSenderClass.getDeclaredConstructor().newInstance();
					logger.info("Created EventSender class");
				} else { 
					logger.info("appConfig.properties file doesn't contain the information about EventSender class");
				}
			}
		}
	}  
	
	// 6. 인터페이스 규격에 맞는 정상적인 메서드 구현 및 내부 붕괴된 중괄호 구조 복구
	@Override
	public void createFixedDeposit(FixedDepositDetails fixedDepositDetails) throws Exception {
		// 7. 정의되지 않은 변수 event 대신 파라미터로 넘어온 데이터를 활용해 이벤트 전송하도록 수정
		if (eventSender != null) {
			eventSender.sendEvent(fixedDepositDetails); 
		}
		
		// 비즈니스 로직 예시: DAO를 통한 저장 처리
		if (fixedDepositDao != null) {
			fixedDepositDao.createFixedDeposit(fixedDepositDetails);
		}
	}
} // 8. 불필요하게 떠돌던 중괄호들 완전 청소 및 클래스 마감