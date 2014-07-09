package framework.externalInterfaces;

public interface IAccount {

	public String getAcctNumber();

	public Double getBalance();

	public void deposit(double amount);

	public String[] generateReport();

	public ICustomer getAccountOwner();

	public double getInterstRate();

	public String getAccountType();

}
