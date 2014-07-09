package framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.ITransaction;

public class Account implements IAccount {

	private String acctNumber;
	private double balance;
	private List<ITransaction> entryList;
	private ICustomer accountOwner;
	private String acctType;

	public Account(String acctNumber, ICustomer cust) {
		super();
		this.acctNumber = acctNumber;
		accountOwner = cust;
		entryList = new ArrayList<>();
	}

	@Override
	public String getAcctNumber() {
		// TODO Auto-generated method stub
		return acctNumber;
	}

	@Override
	public Double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		Date today = new Date();
		System.out.println("existing " + balance);
		balance += amount;
		System.out.println("new " + balance);
                addAccount(new Transaction(today.toString(), amount));
		//entryList.add(new Transaction(today.toString(), amount));

	}
        
        private void addAccount(ITransaction transaction){
            entryList.add(transaction);
        }

	@Override
	public String[] generateReport() {
		String[] custDetails = accountOwner.getCustomerDetails();
		String[] acctInfo = new String[custDetails.length + 1];
		for (int i = 0; i < custDetails.length; i++) {
			acctInfo[i] = custDetails[i];
		}
		acctInfo[custDetails.length] = Double.toString(balance);
		return acctInfo;
	}

	public ICustomer getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(ICustomer accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public double getInterstRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return null;
	}

}
