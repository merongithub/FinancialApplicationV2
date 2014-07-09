package creditcard.view;

import creditcard.controller.CreditCardController;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;

public class AddCreditcardFrame extends AddAccountFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreditCardController control;

	public AddCreditcardFrame(MainFrame parent) {
		super(parent);
		control = CreditCardController.getInstance();
		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Gold");
		getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36, 12, 84, 24);

		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		// JRadioButton_Silver.addActionListener(l)
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36, 36, 84, 24);

		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Bronze");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36, 60, 84, 24);

		getContentPane().add(JTextField_CCNR);
		JTextField_CCNR.setBounds(84, 252, 156, 20);

		getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(84, 276, 156, 20);

		JLabel6.setText("CC number");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 252, 96, 24);
		Label7.setText("Exp. Date");
		getContentPane().add(Label7);
		Label7.setForeground(java.awt.Color.black);
		Label7.setBounds(12, 276, 72, 24);
		JButton_OK.addActionListener(control
				.getAddCreditCardAccountOkListener(this));
		JRadioButton_Silver.addMouseListener(control.getSilverBoxListener());
		JRadioButton_Bronze.addMouseListener(control.getBronzeBoxListener());
		JRadioButton_Gold.addMouseListener(control.getGoldBoxListener());

	}

	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel Label7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();

	public String[] getAccountInfo() {
		String[] fields = new String[8];
		fields[0] = JTextField_NAME.getText();
		fields[1] = JTextField_STR.getText();
		fields[2] = JTextField_CT.getText();
		fields[3] = JTextField_ST.getText();
		fields[4] = JTextField_ZIP.getText();
		fields[5] = JTextField_CCNR.getText();
		fields[6] = JTextField_ExpDate.getText();
		fields[7] = JTextField_Email.getText();

		return fields;
	}

}
