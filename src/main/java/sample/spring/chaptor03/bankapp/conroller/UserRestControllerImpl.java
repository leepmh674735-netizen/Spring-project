package sample.spring.chaptor03.bankapp.conroller;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class UserRestControllerImpl implements UserRequestController {
	private ServiceTemplate serviceTemplate;
	
	public UserRequestControllerImpl(ServiceTemplate serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
		
	}
	
	@Override
	public void sumbitRequst(Request request) {
		
		serviceTemplate.getJmsMessageSender();
		
	}
}