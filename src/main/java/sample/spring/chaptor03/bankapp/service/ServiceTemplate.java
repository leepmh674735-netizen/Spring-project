package sample.spring.chaptor03.bankapp.service;

import java.beans.ConstructorProperties;

public class ServiceTemplate {
	
	@ConstructorProperties({"jmsMessageSender", "emailMessageSender", "webServiceInvoker"})
	public ServiceTemplate(JmsMessageSender jmsMessageSender, 
	    EmailMessageSender emailMessageSender,
	    WebServiceInker webServiceInvoker) {}
	
}
