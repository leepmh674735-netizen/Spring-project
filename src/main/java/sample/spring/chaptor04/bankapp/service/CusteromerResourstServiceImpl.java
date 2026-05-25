package sample.spring.chapter04.bankapp.service; // 1. 오타 수정: chaptor04 -> chapter04

import java.beans.ConstructorProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;      // 2. 누락된 ApplicationContext 임포트 추가
import org.springframework.context.ApplicationContextAware; // 3. 누락된 Awareness 인터페이스 임포트 추가

// 4. 의도한 도메인 및 DAO 클래스들의 올바른 패키지 경로 임포트 가정
import sample.spring.chapter04.bankapp.domain.CustomerRequestDetails;
import sample.spring.chapter04.bankapp.dao.CustomerRequestDao;

// 5. 인터페이스명 일치화 및 ApplicationContextAware 구현(implements) 선언 추가
public class CustomerRequestServiceImpl implements CustomerRequestService, ApplicationContextAware {
	
	private CustomerRequestDetails customerRequestDetails;
	private CustomerRequestDao customerRequestDao;
	private ApplicationContext applicationContext; // 6. 누락된 내부 컨텍스트 변수 필드 선언
	
	// 7. 파라미터명과 어노테이션 배열 내부의 철자 오타 전면 교정 (Detials, Reest, Rest -> RequestDetails, RequestDao)
	@ConstructorProperties({ "customerRequestDetails", "customerRequestDao" })
	public CustomerRequestServiceImpl(CustomerRequestDetails customerRequestDetails, 
			CustomerRequestDao customerRequestDao) {
		this.customerRequestDetails = customerRequestDetails;
		this.customerRequestDao = customerRequestDao;
	}
	
	// 8. ApplicationContextAware 규격에 맞게 정확하게 컨텍스트 주입 세터 구현
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	// 9. 메서드명 오타 교정 (sumbit -> submitRequest)
	public void submitRequest(String requestType, String requestDescription) {
		// 10. 프로토타입(추정) 빈을 컨텍스트로부터 매번 안전하게 새로 받아오도록 처리 (Detials, Resource -> RequestDetails)
		CustomerRequestDetails freshDetails = applicationContext.getBean(CustomerRequestDetails.class);
		
		freshDetails.setType(requestType);
		freshDetails.setDescription(requestDescription);
		
		// 11. 오타 교정 및 호출 (sumbmitRequest -> submitRequest)
		customerRequestDao.submitRequest(freshDetails);
	} // 12. 유실되었던 메서드 닫는 중괄호 복구
} // 13. 클래스 닫는 중괄호 복구 완료