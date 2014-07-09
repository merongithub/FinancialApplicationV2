package creditcard.model;

import framework.model.Account;
import framework.externalInterfaces.ICustomer;

public abstract class CreditCardAccount extends Account {
	private String expireDate;
	private double previousMonthBalance;
	private double credits;
	private double charges;
	private double currentBalance;

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public double getPreviousMonthBalance() {
		return previousMonthBalance;
	}

	public void setPreviousMonthBalance(double previousMonthBalance) {
		this.previousMonthBalance = previousMonthBalance;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public CreditCardAccount(ICustomer cust, String accnr, String expDate) {
		super(accnr, cust);
		this.expireDate = expDate;
	}

	public abstract double getCurrentMonthlyBalance();

	public abstract double getMonthlyDues();

}
