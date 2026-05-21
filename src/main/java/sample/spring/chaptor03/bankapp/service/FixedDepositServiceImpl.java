package sample.spring.chaptor03.bankapp.service;

public class FixedDepositServiceImpl implements  FixedDepositService {
	
	private EventSenderFactoryBean eventSenderFactoryBean;
	
	
	public void setEventSenderFactoryBean(EventSenderFactoryBean eventSenderFactoryBean) {
		this.eventSenderFactoryBean = eventSenderFactoryBean;
	}
	
	public void createFixedDeposit(FixedDepositDetails fixedDepositDeails) {
		EventSender eventSender = eventSenderFactoryBean.getObject();
		eventSender.sendEvent(event);
	}

}
