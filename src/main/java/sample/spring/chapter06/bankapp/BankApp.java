package sample.spring.chapter06.bankapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.spring.chapter06.bankapp.service.BankAppConfiguration;
import sample.spring.chaptor01.bankapp.FixedDepositService;
import sample.spring.chaptor06.bankapp.domain.FixedDepositDetails;

public class BankApp {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BankAppConfiguration.class);
	
		FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
		fixedDepositService.createFixedDeposit
		(new FixedDepositDetails(1, 1000, 12, "someemail@somedomain.com"));
			
	}

}
