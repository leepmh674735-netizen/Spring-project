package sample.spring.chapter04.bankapp.service; // 1. 오타 수정: chaptor04 -> chapter04

// 2. 핵심 스프링 컨텍스트 구현체 임포트 추가
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 3. 표준 SLF4J 로거 라이브러리 임포트
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankApp {
	
	// 4. LoggerFactory를 이용한 정석적인 로거 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(BankApp.class);
	
	public static void main(String[] args) throws Exception {
		// 5. ClassPathXmlApplicationContext를 정상 인식하도록 임포트와 함께 구동 경로 지정
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/applicationContext.xml"); // classpath: 접두사는 생략해도 ClassPath인스턴스가 알아서 인식합니다.
		
		logger.info("Beginning with accessing CustomerRegistrationService"); // 오타 수정(Begining, Registractraction)
		
		// 6. 인터페이스 클래스명 및 변수명의 철자 오타 전면 교정 (Registraction -> Registration)
		CustomerRegistrationService customerRegistrationService_1 = context.getBean(CustomerRegistrationService.class);
		customerRegistrationService_1.setAccountNumber("account_1");
		customerRegistrationService_1.setDebitCardNumber("debitCardNumber_1"); // 오타 수정(CarNumber -> CardNumber)
		customerRegistrationService_1.register();
		logger.info("Registered customer with id account_1");
		
		CustomerRegistrationService customerRegistrationService_2 = context.getBean(CustomerRegistrationService.class);
		customerRegistrationService_2.setAccountNumber("account_2");
		customerRegistrationService_2.setDebitCardNumber("debitCardNumber_2");
		customerRegistrationService_2.register();
		
		logger.info("Registered customer with id account_2");
		logger.info("Done with accessing CustomerRegistrationService");
		
	} // 7. 유실되었던 main 메서드 닫는 중괄호 복구
} // 8. 클래스 닫는 중괄호 복구 완료