package bank.model;

import framework.model.Account;
import framework.externalInterfaces.ICustomer;

public class Savings extends Account {

	private double interestRate = 0.15;

	public Savings(ICustomer cust, String acctNo) {
		super(acctNo, cust);
	}

	public double getInterstRate() {
		return interestRate;
	}

	public String getAccountType() {
		return "Saving";
	}
}
