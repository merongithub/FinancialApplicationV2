package framework.model;

import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.IAccountFactory;

public class AccountFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer cust, String acctNo, String acctType) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal) {
		// TODO Auto-generated method stub
		if (customerType.equals("P")) {
			return new Person(name, email, add, anyVal);
		}
		return new Company(name, email, add, anyVal);
	}

}
