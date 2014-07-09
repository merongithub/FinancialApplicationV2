package creditcard.view;

import creditcard.controller.CreditCardController;
import framework.view.MainFrame;
import framework.view.TransactionFrame;

public class DepositFrame extends TransactionFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreditCardController control;

	public DepositFrame(MainFrame parent, String title, String aaccnr) {
		super(parent, title, aaccnr);
		control = CreditCardController.getInstance();
		JButton_OK.addActionListener(control.getDepositOKListener(this));
	}

	public String getAmount() {
		// double balance=control.g
		return JTextField_Deposit.getText();
	}
}
