package bank.view;

import bank.controller.BankController;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;

public class AddPersonAccountFrame extends AddAccountFrame {
	BankController control;

	public AddPersonAccountFrame(MainFrame parent) {
		super(parent);
		control = BankController.getInstance();
		JRadioButton_Chk.setText("Checking");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 12, 84, 24);
		JRadioButton_Sav.setText("Saving");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 36, 84, 24);
		JLabel6.setText("Birth date");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 252, 96, 24);
		getContentPane().add(JTextField_BirthDate);
		JTextField_BirthDate.setBounds(84, 252, 156, 20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 72, 96, 24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84, 72, 156, 20);

		JButton_OK.addActionListener(control.getAddPersonAccountFrameOkListener(this));
		JRadioButton_Chk.addMouseListener(control.getCheckingBoxListener());
		JRadioButton_Sav.addMouseListener(control.getSavingBoxListener());

	}

	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel Label7 = new javax.swing.JLabel();
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	javax.swing.JTextField JTextField_BirthDate = new javax.swing.JTextField();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();

	public String[] getAccountInfo() {
		String[] fields = new String[8];
		fields[0] = JTextField_NAME.getText();
		fields[1] = JTextField_STR.getText();
		fields[2] = JTextField_CT.getText();
		fields[3] = JTextField_ST.getText();
		fields[4] = JTextField_ZIP.getText();
		fields[5] = JTextField_BirthDate.getText();
		fields[6] = JTextField_ACNR.getText();
		fields[7] = JTextField_Email.getText();

		return fields;
	}
}
