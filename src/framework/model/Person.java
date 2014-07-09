package framework.model;

import java.util.List;

import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.IPerson;

public class Person extends Customer implements IPerson {

	private String birthDate;

	public Person(String name, String email, IAddress address, String birthdate) {
		super(name, email, address);
		// TODO Auto-generated constructor stub
		this.birthDate = birthdate;
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
		// TODO Auto-generated method stub

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
	public String getBirthDate() {
		// TODO Auto-generated method stub
		return this.birthDate;
	}

	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return "P";
	}

}
