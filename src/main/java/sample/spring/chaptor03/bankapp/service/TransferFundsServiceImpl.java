package sample.spring.chaptor03.bankapp.service;

public class TransferFundsServiceImpl implements TransferFundsService {
	
	@ConstructorProperties({"webServiceUrl", "active", "timeout","numberOfRetrialAttempts"})
	public TransferFundsServiceImpl(String webServiceUrl, boolean active, long timeout,
			int numberOfRetrialAttempts) {..}

}
