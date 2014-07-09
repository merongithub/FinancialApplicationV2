package creditcard.model;

import framework.externalInterfaces.ICustomer;

public class Gold extends CreditCardAccount {
	double interestRate = 0.06;

	public Gold(ICustomer cust, String accnr, String expDate) {
		super(cust, accnr, expDate);
	}

	@Override
	public double getCurrentMonthlyBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMonthlyDues() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
