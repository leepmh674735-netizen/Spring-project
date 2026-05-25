package sample.spring.chapter06.bankapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BankAppConfiguration {
	
	@Bean(name = "customerRegistractionService")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CustomerRegistractionService customerRegistrationService() {
		return new CustomerRegistrationServiceImpl();
	}

}
