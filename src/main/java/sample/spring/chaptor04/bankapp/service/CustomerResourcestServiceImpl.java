package sample.spring.chapter04.bankapp.service; // 1. 오타 수정: chaptor04 -> chapter04

import java.beans.ConstructorProperties;
import sample.spring.chapter04.bankapp.dao.CustomerRequestDao;
import sample.spring.chapter04.bankapp.domain.CustomerRequestDetails;

// 2. 인터페이스명 오타 수정: CustomerRequestService
public abstract class CustomerRequestServiceImpl implements CustomerRequestService {
	
	// 3. 필드 타입 및 변수명 오타 전면 교정
	private CustomerRequestDetails customerRequestDetails;
	private CustomerRequestDao customerRequestDao;
	
	// 4. 세터(Setter) 메서드명 및 파라미터 타입 오타 교정
	public void setCustomerRequestDetails(CustomerRequestDetails customerRequestDetails) {
		this.customerRequestDetails = customerRequestDetails;
	}
	
	// 5. 자바 예약어 오타 교정 (pubic -> public) 및 세미콜론(;) 누락 수정
	public void setCustomerRequestDao(CustomerRequestDao customerRequestDao) {
		this.customerRequestDao = customerRequestDao; // 변수명 일치화
	}
	
	// 6. 클래스명과 생성자명을 CustomerRequestServiceImpl로 동일하게 일치시켰습니다
	@ConstructorProperties({ "customerRequestDao" })
	public CustomerRequestServiceImpl(CustomerRequestDao customerRequestDao) {
		this.customerRequestDao = customerRequestDao;
	}
	
	// 7. 핵심 포인트: 아래 submitRequest에서 호출하는 추상 메서드명과 완벽히 매칭 (Detaills -> Details)
	public abstract CustomerRequestDetails getCustomerRequestDetails();
	
	@Override
	public void submitRequest(String requestType, String requestDescription) {
		// 8. Lookup Method를 통해 프로토타입 스코프의 빈을 컨텍스트로부터 매번 새로 주입받음
		CustomerRequestDetails freshDetails = getCustomerRequestDetails();
		
		freshDetails.setType(requestType);
		freshDetails.setDescription(requestDescription);
		
		// 9. 주입받은 요청 정보를 DAO를 통해 데이터베이스에 저장 처리하는 로직 완성
		if (customerRequestDao != null) {
			customerRequestDao.submitRequest(freshDetails);
		}
	}
}