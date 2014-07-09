package framework.model;

import java.util.ArrayList;
import java.util.List;

import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;

public class Customer implements ICustomer {

	private String custName;
	private String custEmailAddress;
	private IAddress custAddress;
	private List<IAccount> accountList;
	private List<String> emailList;

	public Customer(String name, String email, IAddress address) {
		this.custAddress = address;
		accountList = new ArrayList<>();
		emailList = new ArrayList<>();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return custName;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return custEmailAddress;
	}

	@Override
	public void AddAccount(IAccount acct) {
		accountList.add(acct);

	}

	@Override
	public void removeAccount(IAccount acct) {
		accountList.remove(acct);

	}

	@Override
	public List<IAccount> getAccountList() {
		// TODO Auto-generated method stub
		return accountList;
	}

	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String emailMessage) {
		// TODO Auto-generated method stub
		emailList.add(emailMessage);
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	@Override
	public String[] getCustomerDetails() {

		String[] custInfo = new String[2];
		custInfo[0] = custName;
		custInfo[1] = custAddress.getAddressDetails();
		return custInfo;

	}

}
