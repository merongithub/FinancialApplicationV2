package bank.model;

import framework.model.Rule;

public class BankPredicate extends Rule{

	private double depositAmount;

	public BankPredicate(double amount) {
		depositAmount = amount;
	}

	@Override
	public boolean isGreaterThanLimit() {
		// TODO Auto-generated method stub
		return depositAmount > 500;
	}

}
