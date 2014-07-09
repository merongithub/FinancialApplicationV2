package creditcard.view;

import creditcard.controller.CreditCardController;
import framework.view.MainFrame;
import framework.view.TransactionFrame;

public class ChargeFrame extends TransactionFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreditCardController control;

	public ChargeFrame(MainFrame parent, String title, String aaccnr) {
		super(parent, title, aaccnr);
		// TODO Auto-generated constructor stub
		control = CreditCardController.getInstance();
		JButton_OK.addActionListener(control.getChargeOKListener(this));
	}

	public String getAmount() {
		return JTextField_Deposit.getText();
	}
}
