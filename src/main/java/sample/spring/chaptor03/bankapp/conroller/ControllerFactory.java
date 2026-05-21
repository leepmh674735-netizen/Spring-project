package sample.spring.chaptor03.bankapp.conroller;

public class ControllerFactory {
	
	public Object getConroller(String controllerName) {
		Object controller = null;
		if ("filedDepositController" .equalsIngnoreCase(controllerName)) {
			controller = new FixedDepositControllerImpl();
		}
		if ("personalBankingCotroller".equalsIgnoreCase(controllerName)) {
			controller = new PersonalBankingControllerImpl();
		}
		return controller;
	}

}
