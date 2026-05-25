package sample.spring.chapter03.bankapp.beans; // 1. 오타 수정: chaptor03 -> chapter03

import java.beans.ConstructorProperties;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

// 2. 표준적이고 안정적인 SLF4J 로깅 라이브러리 임포트
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataTypesExample {
	
	// LoggerFactory를 사용해 정석대로 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(DataTypesExample.class);
	
	@SuppressWarnings("rawtypes")
	@ConstructorProperties({  
		"byteArrayType", "charType", "charArray",
		"classType", "currencyType", "booleanType", "dateType", "longType", // 3. currencyType 누락 반영 및 대소문자 일치
		"doubleType", "propertiesType", "listType", "mapType", "setType",
		"anotherPropertiesType" // 4. 오타 수정: auther -> another
	})
	public DataTypesExample(byte[] byteArrayType, char charType,
			char[] charArray, Class<?> classType, Currency currencyType, // 5. 예약어 오류 수정: class -> Class<?>
			boolean booleanType, Date dateType, long longType,
			double doubleType, Properties propertiesType, List<Integer> listType, // 6. 오타 수정: propertiesTypes -> propertiesType
			Map mapType, Set setType, Properties anotherPropertiesType) { // 7. 오타 수정: antherPropertiesType -> anotherPropertiesType
		
		// 8. SLF4J의 치환자({}) 문법을 활용해 깔끔하고 안전하게 로그 출력
		logger.info("classType: {}", classType.getName());
		logger.info("listType: {}", listType);
		logger.info("mapType: {}", mapType);
		logger.info("setType: {}", setType);
		logger.info("anotherPropertiesType: {}", anotherPropertiesType); // 9. 생성자 파라미터명 변수와 일치하도록 교정
	}
}