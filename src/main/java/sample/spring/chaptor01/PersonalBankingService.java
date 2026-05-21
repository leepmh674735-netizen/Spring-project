package sample.spring.chaptor01;

public class PersonalBankingService {
	private JmsMessageSendaer jmsMessageSender;
	private EmailMessageSender emailMessageSender;
	private WebServiceInvoker webServiceInvoker;
	
	public void setJmsMessageSender(JmsMessageSender jmsMessageSender jmsMessageSender) {
		this.jmsMessageSender = jmsMessageSender;
	}
	
	public void setEmailMessageSender(EmailMessageSender emailMessageSender) {
		this.emailMessageSender = emailMessageSender;
	}
	
	public void setWebServiceInvoker(WebServiceInvoker webServiceInvoker) {
		this.webServiceInvoker = webServiceInvoker;
	}

}
