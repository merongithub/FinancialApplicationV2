package creditcard.view;

import javax.swing.UIManager;

import creditcard.controller.CreditCardController;
import framework.view.MainFrame;

public class CreditcardFrame extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5460470970913988162L;

	private CreditCardController control;

	public CreditcardFrame(String title) {
		super();
		control = CreditCardController.getInstance();
		this.setTitle(title);
		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);

		JButton_Deposit.addActionListener(control.getDepositListener(this));
		JButton_Withdraw.addActionListener(control.getChargeListener(this));
		JButton_Addinterest.addActionListener(control
				.getAddInterestListener(this));
		JButton_NewCCAccount.addActionListener(control
				.getNewCreditCardAccountListener(this));
		JButton_GenBill
				.addActionListener(control.getGenerateBillListener(this));

		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[8];
	}

	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();

	public void updateTable(String[] data) {
		rowdata[0] = data[0];
		rowdata[1] = data[1];
		rowdata[2] = data[2];
		rowdata[3] = data[3];
		rowdata[4] = data[4];
		rowdata[5] = data[5];
		rowdata[6] = data[6];
		rowdata[7] = data[7];
		model.addRow(rowdata);
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
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
			(new CreditcardFrame("Credit Card Processing"))
					.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
