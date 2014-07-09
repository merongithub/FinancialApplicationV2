package creditcard.model;

import framework.model.Rule;

public class CreditCardPredicate extends Rule{

	private double withdrawAmount;

	public CreditCardPredicate(double amount) {
		withdrawAmount = amount;
	}

	@Override
	public boolean isGreaterThanLimit() {
		return withdrawAmount > 400;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

}
