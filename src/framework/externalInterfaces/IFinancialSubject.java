package framework.externalInterfaces;

public interface IFinancialSubject {

	public void notifyCustomer();

	public void attach(ICustomer cust);

	public void detach(ICustomer cust);

}
