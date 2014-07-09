package framework.model;

import java.util.List;

import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.IOrganization;

public class Company extends Customer implements IOrganization {

	private String numberOfEmployees;

	public Company(String name, String email, IAddress address,
			String numberOfEmployees) {
		super(name, email, address);
		this.numberOfEmployees = numberOfEmployees;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void AddAccount(IAccount acct) {
		super.AddAccount(acct);

	}

	@Override
	public void removeAccount(IAccount acct) {
		super.removeAccount(acct);

	}

	@Override
	public List<IAccount> getAccountList() {
		// TODO Auto-generated method stub
		return super.getAccountList();
	}

	@Override
	public String getNumOfEmployees() {
		// TODO Auto-generated method stub
		return numberOfEmployees;
	}

	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return "Organization";
	}

}
