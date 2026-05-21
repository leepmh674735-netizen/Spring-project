package sample.spring.chaptor01.bankapp;

import java.util.logging.Logger;

public class FixedDepsitController {
	
	private FixedDepositService fixedDepositService;
	
	public FixedDepositController() {
		Logger.info("initializing");
	}
	
	public void setFixedDeositService(FixedDepositService fixedDepositService) {
		Logger.info("Setting fixedDepositService property");
		this.fixedDepositService = fixedDepositService;
	}
	
	public void sumbit() {
		fixedDepositService.createFixedDeposit(new FixedDepsitDetails( 1, 1000,
				365 , "someemail@something.com"));
	}

}
