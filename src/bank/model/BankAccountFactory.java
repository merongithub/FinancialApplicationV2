package bank.model;

import framework.model.AccountFactory;
import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;

public class BankAccountFactory extends AccountFactory {

	@Override
	public IAccount createAccount(ICustomer cust, String acctNo, String acctType) {
		// TODO Auto-generated method stub

		if (acctType.equals("C")) {
			return new Checking(cust, acctNo);
		}
		return new Savings(cust, acctNo);
	}

	@Override
	public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal) {
		return super.createCustomer(name, customerType, add, email, anyVal);

	}
}
