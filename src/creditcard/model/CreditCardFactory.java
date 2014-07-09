package creditcard.model;

import framework.model.AccountFactory;
import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;

public class CreditCardFactory extends AccountFactory {

	public IAccount createAccount(ICustomer cust, String acctNo,
			String acctType, String expDate) {
		// TODO Auto-generated method stub

		if (acctType.equals("Gold")) {
			return new Gold(cust, acctNo, expDate);

		}
		if (acctType.equals("Silver")) {
			return new Silver(cust, acctNo, expDate);

		}

		return new Bronze(cust, acctNo, expDate);
	}

	public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal) {
		// TODO Auto-generated method stub
		return super.createCustomer(name, customerType, add, email, anyVal);
	}

}
