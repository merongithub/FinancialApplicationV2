package bank.view;

import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TransactionFrame;

public class WithdrawFrame extends TransactionFrame {
	BankController control;

	public WithdrawFrame(MainFrame parent, String title, String aaccnr) {
		super(parent, title, aaccnr);
		// TODO Auto-generated constructor stub
		control = BankController.getInstance();
		JButton_OK.addActionListener(control.getWithdrawOKListener(this));
	}

	public String getAmount() {
		return JTextField_Deposit.getText();
	}
}
