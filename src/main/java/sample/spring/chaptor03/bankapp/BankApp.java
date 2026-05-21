package sample.spring.chaptor03.bankapp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
	private static Logger logger = Logger.getLogger(BankApp.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
				
		logger.info("Invoking getBean(\"eventSenderFactory\") returns : " +
				context.getBean("eventSenderFactory"));
		logger.info("Invoking getBean(\"&eventSenderFactory\") returns : " +
				context.getBean("&eventSenderFactory"));
	}
}