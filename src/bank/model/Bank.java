package bank.model;

import java.util.LinkedList;
import java.util.List;

import bank.controller.BankController;
import bank.view.BankFrame;
import framework.model.CustomerFactory;
import framework.model.FinancialCompany;
import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.IAccountFactory;
import framework.externalInterfaces.ICustomerFactory;
import framework.externalInterfaces.IRule;
import framework.model.Transaction;
import java.util.ArrayList;
import java.util.Date; 

public class Bank extends FinancialCompany {
	ICustomer customer;
	IAccount acct;
        ArrayList<Transaction> listTran=new ArrayList<Transaction>();

	public Bank() {

	}

	public void runRule() {

	}

	public void addAccount(String name, IAddress addr, String anyVal,
			String acctNo, String acctType, String custType, String email) {

	        IAccountFactory Bfactory = new BankAccountFactory();
                ICustomerFactory factory=new CustomerFactory();
		customer = factory.createCustomer(name, custType, addr, email, anyVal);
		super.customerList.add(customer);
		acct = Bfactory.createAccount(customer, acctNo, acctType);
		System.out.println("test 1 =" + acct);
		super.accountList.add(acct);

	}

	public double deposit(String accnr, double amount, IRule depositRule) {
		// deposit
		IRule predicate = depositRule;

		acct = getAccount(accnr);
		if (acct.getAccountOwner().getCustomerType().equals("P")) {
			if (predicate.isGreaterThanLimit()) {
				super.setEmailNotification("You have deposited morethan 500");
				//notifyCustomer();

			} else {
//                            Date myD=new Date();
//                             Transaction tran=new Transaction( myD.toString(), amount);
//                             listTran.add(tran);
			     acct.deposit(amount);       
			}
		}
		// if for company
		else {
			acct.deposit(amount);
		}
		return acct.getBalance();

	}

	public boolean withdraw(String accnr, double amount, IRule withdrawRule) {
		// withdraw
		IRule predicate = withdrawRule;
		acct = getAccount(accnr);
		double incomingAmount = amount;
		double balance = acct.getBalance();
		amount = amount * -1;
		if (acct.getAccountOwner().getCustomerType().equals("P")) {
			if (predicate.isGreaterThanLimit() || balance < incomingAmount) {
				super.setEmailNotification("Transaction Cancelled! Your balance either too low or your requested amount is more than the withdraw Limit");
				System.out.println(super.getEmailNotification());
				//notifyCustomer();
				return false;
			} else {
                            
                            Date myD=new Date();
                              Transaction tran=new Transaction( myD.toString(), amount);
                                listTran.add(tran);
				acct.deposit(amount);
				return true;
			}
		} else {
			acct.deposit(amount);
			super.setEmailNotification("Withdraw Transaction Occured");
			System.out.println(super.getEmailNotification());
			notifyCustomer();
			return true; 
                }

	}

	public List<String[]> generateReport() {
		// generate monthly report
		List<String[]> report = new LinkedList<String[]>();
		for (IAccount acc : super.accountList) {
			report.add(acc.generateReport());
		}
		return report;
	}

	public void addInterest() {
		// add interest
		super.addInterest();
	}

	private IAccount getAccount(String acctno) {

		if (super.accountList.isEmpty()) {
			return null;
		}
		for (IAccount acc : super.accountList) {
			System.out.println("test2 =" + acc);
			if (acc.getAcctNumber().equals(acctno))
				return acc;		}
		return null;
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		// single instance if controller
		BankController control = BankController.getInstance();
		control.setbank(bank);
		BankFrame frm = new BankFrame();
		control.setbankfrm(frm);
		frm.setVisible(true);
	} 
}
