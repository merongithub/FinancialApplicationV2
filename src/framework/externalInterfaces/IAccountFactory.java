package framework.externalInterfaces;

public interface IAccountFactory {

	public IAccount createAccount(ICustomer cust, String acctNo, String acctType);

	public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal);

}
