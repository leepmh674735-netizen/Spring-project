package sample.spring.chapter05.bankapp.dao; // 1. 오타 수정: chaptor05 -> chapter05

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// 2. 스프링 부트 및 표준 자바 진영에서 사용하는 SLF4J 로거 임포트
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 3. 클래스명 오타 교정 (DepsitDaompl -> DepositDaoImpl)
public class FixedDepositDaoImpl implements FixedDepositDao {
	
	// 4. 정석적인 로거 생성 방식으로 교정
	private static final Logger logger = LoggerFactory.getLogger(FixedDepositDaoImpl.class);
	
	private DatabaseConnection connection;
	
	// 5. 스프링 빈이 생성되고 의존성 주입이 완료된 후 자동으로 호출되는 초기화 메서드
	@PostConstruct
	public void initializeDbConnection() {
		// 6. 물음표(?) 오타를 기호(')로 수정하고 SLF4J logger.info 문법으로 교정
		logger.info("FixedDepositDaoImpl's initializeDbConnection method invoked");
		this.connection = DatabaseConnection.getInstance();
	}
	
	// 7. 스프링 컨테이너가 종료되어 빈이 소멸하기 직전에 자동으로 호출되는 메서드
	@PreDestroy
	public void releaseDbConnection() {
		logger.info("FixedDepositDaoImpl's releaseDbConnection method invoked"); // 오타 수정(releas)
		
		// 8. 안정성 추가: connection 객체가 정상적으로 존재할 때만 자원 해제를 수행하여 NullPointerException 방지
		if (this.connection != null) {
			this.connection.releaseConnection();
		}
	}
}