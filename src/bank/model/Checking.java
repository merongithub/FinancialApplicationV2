package bank.model;

import framework.model.Account;
import framework.externalInterfaces.ICustomer;

public class Checking extends Account {

	private double interestRate = 0.1;

	public Checking(ICustomer cust, String acctNo) {
		super(acctNo, cust);
	}

	public String getAccountType() {
		return "Checking";
	}

	public double getInterstRate() {
		return interestRate;
	}
}
