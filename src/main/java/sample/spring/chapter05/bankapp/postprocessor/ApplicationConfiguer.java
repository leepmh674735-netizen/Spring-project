package sample.spring.chapter05.bankapp.postprocessor; // 1. 오타 수정: chaptor05 -> chapter05

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

// 2. 스프링 표준 SLF4J 로깅 라이브러리 임포트
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 3. 클래스 선언부 철자 일치화 (Configuer -> Configurer)
public class ApplicationConfigurer implements BeanFactoryPostProcessor {
	
	// 4. 정석적인 로거 인스턴스 생성 방법으로 교정
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfigurer.class);
	
	public ApplicationConfigurer() {
		// 5. 인스턴스 생성 시 정상 로깅 (C -> c 소문자 수정)
		logger.info("Created ApplicationConfigurer instance");
	}
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		    
		for (int i = 0; i < beanDefinitionNames.length; i++) {
			// 6. 변수명 오타 교정 (beansDefinitionNames -> beanDefinitionNames)
			String beanName = beanDefinitionNames[i];
			
			// 7. 메서드명 오타 교정 (getBeanDefinitition -> getBeanDefinition)
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
			
			// 8. 메서드명 오타 교정 (setAuthowireCandiate -> setAutowireCandidate)
			beanDefinition.setAutowireCandidate(false);
		    	
			if (beanDefinition.isSingleton()) {
				// 9. 누락된 내부 검증 헬퍼 메서드(hasPrototypeDependency)와 이름 일치화
				if (hasPrototypeDependency(beanFactory, beanDefinition)) {
					logger.error("Singleton-scoped '{}' bean is dependent on a prototype-scoped bean.", beanName);
				}
			}
		}
	}

	// 10. 컴파일 에러 해결을 위해 누락된 프로토타입 의존성 검증 로직 추가 (추상적 예시)
	private boolean hasPrototypeDependency(ConfigurableListableBeanFactory beanFactory, BeanDefinition beanDefinition) {
		// 실제 상용 환경에서는 beanDefinition.getDependsOn()이나 생성자 주입 인자들을 순회하며
		// 해당 빈들의 Scope가 prototype인지 타겟 빈 정의를 찾아 검사하는 로직이 들어갑니다.
		return false; 
	}
}