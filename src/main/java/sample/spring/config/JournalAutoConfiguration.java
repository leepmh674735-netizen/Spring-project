package sample.spring.config;

import java.util.Properties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. 잘못된 MyBatis Environment 대신 스프링 핵심 환경(Environment) 인터페이스 임포트
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader; // 2. 오타 수정: DafultResourceLoader -> DefaultResourceLoader
import org.springframework.core.io.Resource;              // 3. 잘못된 jakarta.annotation.Resource 교정
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.AbstractController; // 4. 오타 수정: AbstractConroller -> AbstractController

import com.apress.spring.config.JournalProperties;
import com.apress.spring.repository.JournalRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration; // 5. 누락된 REST 설정 클래스 임포트

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET) // 최신 스프링 규격 스펙 명시
@ConditionalOnClass(JournalRepository.class)
@EnableConfigurationProperties(JournalProperties.class)
@ConditionalOnProperty(prefix = "journal", name = { "context-path", "banner" }, matchIfMissing = true)
public class JournalAutoConfiguration extends RepositoryRestMvcAutoConfiguration {
	
	private final String API_PATH = "/api"; // 6. 오타 수정: API_PATA -> API_PATH
	private final String BANNER_PATH = "/META-INF/banner/journal.txt"; // 7. 오타 수정: MATA-INF -> META-INF
	
	@Autowired
	private JournalProperties journal;
	
	@Autowired
	private Environment environment; // 1번에서 교정한 org.springframework.core.env.Environment 바인딩
	
	@Autowired
	private JournalRepository repo; // 8. 중첩 메서드 내부에 갇혀있던 필드를 클래스 레벨로 정상 탈출
	
	// [기능 1] 초기화 시 커스텀 배너 출력 설정 빈
	@Bean
	public InitializingBean simple() {
		return () -> {
			Banner banner = null;
			ResourceLoader resourceLoader = new DefaultResourceLoader(ClassUtils.getDefaultClassLoader());
			Resource resource = resourceLoader.getResource(BANNER_PATH);
			
			if (null == journal.getBanner()) {
				banner = new ResourceBanner(resource);
			} else {
				// 9. 문법 오류 수정: 변수명 앞의 공백과 언더바 분리 에러(_ resource -> _resource)
				Resource _resource = resourceLoader.getResource(journal.getBanner());
				if (_resource.exists()) {
					banner = new ResourceBanner(_resource); // 오타 수정: baner -> banner
				}
			}
			
			// 10. 문법 에러 수정: 마침표(.) 연산자 누락 교정
			if (banner != null) {
				banner.printBanner(environment, environment.getClass(), System.out);
			}
		};
	}
	
	// [기능 2] Spring Data REST 베이스 패스 커스텀 설정 오버라이드
	// 11. 부모 클래스(RepositoryRestMvcAutoConfiguration)의 명세 혹은 스프링 명세 메서드명 일치화
	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) { // 오타 수정(RestConfigration, RestConfiguation)
		if (null == journal.getApiPath()) {
			config.setBasePath(API_PATH); // 12. 괄호가 기형적으로 열려 중첩을 유발하던 구문 완전히 격리 교정
		} else {
			config.setBasePath(journal.getApiPath()); // 오타 수정: joural -> journal
		}
	} // 메서드 정상 마감
		
	// [기능 3] 가상의 내부 저널 컨트롤러 빈 등록
	@Bean
	public AbstractController journalController() {
		return new AbstractController() {
			@Override
			protected ModelAndView handleRequestInternal(HttpServletRequest request, 
					HttpServletResponse response) throws Exception { // 오타 수정: handleReqestInternal -> handleRequestInternal
				ModelAndView model = new ModelAndView();
				model.setViewName("journal");
				model.addObject("journal", repo.findAll());
				return model;
			}
		};
	}
	
	// [기능 4] 매핑 경로를 프로퍼티값으로 동적 지정하는 URL 핸들러 매핑 빈 등록
	@Bean
	public SimpleUrlHandlerMapping urlHandler() { // 오타 수정: SimpleUrlHanderMapping -> SimpleUrlHandlerMapping
		SimpleUrlHandlerMapping handler = new SimpleUrlHandlerMapping();
		handler.setOrder(Integer.MAX_VALUE - 2); // 오타 수정: hander -> handler
		
		Properties mappings = new Properties();
		// 13. 문법 오류 수정: 마침표(.) 대신 잘못 찍힌 쉼표(,) 연산자 교정 (journal, getContextPath() -> journal.getContextPath())
		mappings.put(journal.getContextPath(), "journalController");
		handler.setMappings(mappings);
		
		return handler;
	}
} // 14. 클래스 전체 정렬 및 유출 중괄호 완전 청소 마감