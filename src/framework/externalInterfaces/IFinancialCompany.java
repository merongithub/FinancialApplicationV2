package framework.externalInterfaces;

public interface IFinancialCompany {

	public void addNewAccount(String custType);

	public void deposit(String acctNum, String name, Double amount);

	//public void makeTransaction(String name, Double amount);

	public void addInterest();

}
