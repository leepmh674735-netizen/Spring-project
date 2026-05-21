package sample.spring.chaptor03.bankapp.beans;

import java.util.Currency;
import java.util.Date;
import java.util.Properties;

public class BankDeails {
	private String bankName;
	private byte[] bankPrimaryBusiness;
	private char[] headOfficeAddress;
	private char privateBank;
	private Currency primaryCurrncy;
	private Date dateOfInception;
	private Properties branchAddresses;

}

public void setBankName(String bankingName) {
	this.bankName = bankName;
  }

}
