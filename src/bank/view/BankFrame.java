package bank.view;

import javax.swing.UIManager;

import bank.controller.BankController;
import framework.view.MainFrame;

/**
 * A basic JFC based application.
 */
public class BankFrame extends MainFrame {
	/****
	 * init variables in the object
	 ****/

	javax.swing.JButton JButton_Pac = new javax.swing.JButton();
	javax.swing.JButton JButton_Cac = new javax.swing.JButton();
	private BankController control;

	public BankFrame() {
		super();
		control = BankController.getInstance();
		setTitle("Bank Application.");
		JButton_Withdraw.setText("withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);

		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);

		JButton_Pac.setText("Add personal account");
		JButton_Pac.setActionCommand("jbutton");
		JPanel1.add(JButton_Pac);
		JButton_Pac.setBounds(24, 20, 192, 33);
		JButton_Cac.setText("Add company account");
		JButton_Cac.setActionCommand("jbutton");
		JPanel1.add(JButton_Cac);
		JButton_Cac.setBounds(240, 20, 192, 33);

		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("Zip");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		model.addColumn("Acc no");

		rowdata = new Object[8];

		JButton_Deposit.addActionListener(control.getDepositListener(this));
		JButton_Withdraw.addActionListener(control.getWithdrawListener(this));
		JButton_Addinterest.addActionListener(control.getAddInterestListener(this));
		JButton_Pac.addActionListener(control.getPersonAccountListener(this));
		JButton_Cac.addActionListener(control.getCompanyAccountListener(this));

	}

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

//	static public void main(String args[]) {
//		try {
//			// Add the following code if you want the Look and Feel
//			// to be set to the Look and Feel of the native system.
//
//			try {
//				UIManager.setLookAndFeel(UIManager
//						.getSystemLookAndFeelClassName());
//			} catch (Exception e) {
//			}
//
//			// Create a new instance of our application's frame, and make it
//			// visible.
//			(new BankFrame()).setVisible(true);
//		} catch (Throwable t) {
//			t.printStackTrace();
//			// Ensure the application exits with an error condition.
//			System.exit(1);
//		}
//	}

}
