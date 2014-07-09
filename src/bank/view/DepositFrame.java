package bank.view;

import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TransactionFrame;

public class DepositFrame extends TransactionFrame {
	BankController control;

	private double amount;

	public DepositFrame(MainFrame parent, String title, String aaccnr) {
		super(parent, title, aaccnr);
		control = BankController.getInstance();
		JButton_OK.addActionListener(control.getDepositeOKListener(this));
	}

	public String getAmount() {
		// double balance=control.g
		return JTextField_Deposit.getText();
	}
}
