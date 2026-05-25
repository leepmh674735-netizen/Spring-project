package sample.spring.chapter06.bankapp.service; // 1. 오타 수정: chaptor06 -> chapter06

// 2. 치명적 오류 수정: javax.xml.validation 대신 스프링 표준 Validator 인터페이스 임포트
import org.springframework.validation.Validator;
import org.springframework.validation.BeanPropertyBindingResult; // 3. 누락된 BindingResult 클래스 임포트 추가

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 4. 표준 SLF4J 로깅 라이브러리 임포트
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sample.spring.chapter06.bankapp.dao.FixedDepositDao;
import sample.spring.chapter06.bankapp.domain.FixedDepositDetails;

@Service(value = "fixedDepositService") // 5. 서비스 빈 이름 오타 및 관례 교정 (Depsoit -> Deposit, 첫 글자 소문자)
public class FixedDepositServiceImpl implements FixedDepositService { // 6. 클래스명 오타 교정 (Depoosit -> FixedDepositServiceImpl)
	
	// 7. 누락되었던 로거(logger) 인스턴스 정의 추가
	private static final Logger logger = LoggerFactory.getLogger(FixedDepositServiceImpl.class);
	
	@Autowired
	private Validator validator;
	
	@Autowired
	@Qualifier(value = "myFixedDepositDao")
	private FixedDepositDao myFixedDepositDao;
	
	@Override
	public void createFixedDeposit(FixedDepositDetails fixedDepositDetails) throws Exception { // 8. 파라미터 타입 오타 교정 (Depotsit -> Deposit)
		
		// 9. 클래스명 오타 수정 (BeanPropetyBindingResult -> BeanPropertyBindingResult) 
		// 및 파라미터 변수명 매칭 (Detials -> Details)
		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(fixedDepositDetails, "fixedDepositDetails");
		
		// 10. 문법 파괴 구문 수정: 마침표(.) 대신 쉼표(,)로 객체와 바인딩 결과를 각각 인자로 전달해야 합니다
		validator.validate(fixedDepositDetails, bindingResult);
		
		// 11. 변수명 오타 교정 (bingingResult -> bindingResult)
		if (bindingResult.getErrorCount() > 0) {
			logger.error("Errors were found while validating FixedDepositDetails instance"); // 오타 교정 (insstance)
		} else {
			myFixedDepositDao.createFixedDeposit(fixedDepositDetails); // 변수명 오타 교정 (fixedDepositDetials -> fixedDepositDetails)
			logger.info("Created fixed deposit");
		}
	}
}