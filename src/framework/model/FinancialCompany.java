package framework.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import framework.controller.Controller;
import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IController;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.IFinancialCompany;
import framework.externalInterfaces.IAccountFactory;
import framework.externalInterfaces.IFinancialSubject;
import framework.view.MainFrame;
import javax.swing.UIManager;

public class FinancialCompany implements IFinancialCompany, IFinancialSubject {

	public List<ICustomer> customerList;
	public List<IAccount> accountList;
	IController control = Controller.getInstance();
	IAccountFactory factory = new AccountFactory();
	private String emailNotification = "";

	public String getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(String emailNotification) {
		this.emailNotification = emailNotification;
	}

	public FinancialCompany() {
		customerList = new ArrayList<>();
		accountList = new ArrayList<>();
	}

	@Override
	public void addNewAccount(String custType) {
		
	}

//	@Override
//	public void makeTransaction(String name, Double amount) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		double interest;
		for (IAccount acc : accountList) {
			interest = acc.getBalance() * acc.getInterstRate();
			acc.deposit(interest);
		}

	}

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
		for (ICustomer cus : customerList) {
			cus.update(emailNotification);

		}
	}

	@Override
	public void attach(ICustomer cust) {
		// TODO Auto-generated method stub
		customerList.add(cust);

	}

	@Override
	public void detach(ICustomer cust) {
		// TODO Auto-generated method stub
		customerList.remove(cust);
	}

	@Override
	public void deposit(String acctNum, String name, Double amount) {
		// TODO Auto-generated method stub

	}
        
        static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new MainFrame()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
