package framework.model;

import framework.externalInterfaces.ITransaction;

public class Transaction implements ITransaction {

	private String date;
	private Double amount;

	public Transaction(String date, Double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public Double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

}
