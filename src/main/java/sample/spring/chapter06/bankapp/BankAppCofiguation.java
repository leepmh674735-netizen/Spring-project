package sample.spring.chapter06.bankapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAppCofiguation {
	
	@Bean
	public ExampleBeanPostProcessor exampleBeanPostProcessor() {
		return new ExampleBeanPostProcessor();
	}
	
	@Bean
	public static BeanNamePrinterBeanFacoryPostProcessor applicationConfigurer() {
		return new BeanNamePrinterBeanFactoryPostProcessor();
	}
	

}
