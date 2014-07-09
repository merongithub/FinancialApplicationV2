package creditcard.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import bank.model.BankPredicate;
import creditcard.model.CreditCardPredicate;
import creditcard.model.CreditcardApplication;
import creditcard.view.AddCreditcardFrame;
import creditcard.view.ChargeFrame;
import creditcard.view.CreditcardFrame;
import creditcard.view.DepositFrame;
import framework.model.Address;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.IRule;
import framework.view.AddAccountFrame;
import framework.view.Controller;
import framework.view.MainFrame;
import framework.view.TransactionFrame;
import framework.view.ReportFrame;

public class CreditCardController extends Controller {

	private CreditcardApplication creditCardApplication;
	private CreditcardFrame creditCardFrame;
	private DepositFrame depositFrame;
	private ChargeFrame chargeFrame;
	private TransactionFrame currentActiveFrame;
	private AddAccountFrame addAccountFrame;
	private String accountType;
	String accountNo;
	int currentSelection;

	private static CreditCardController instance;

	private CreditCardController() {
	}

	public static CreditCardController getInstance() {
		if (instance == null) {
			instance = new CreditCardController();
		}
		return instance;
	}

	class NewAccountListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddCreditcardFrame addCreditCardFrame = new AddCreditcardFrame(
					creditCardFrame);
			addCreditCardFrame.setVisible(true);
		}

	}

	class GenerateBillListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			List<String[]> report = creditCardApplication.generateReport();
			ReportFrame reportFrm = new ReportFrame(creditCardFrame);
			reportFrm.displayReport(report);
			reportFrm.setVisible(true);
		}

	}

	class DepositListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			currentSelection = creditCardFrame.JTable1.getSelectionModel()
					.getMinSelectionIndex();
			if (currentSelection >= 0) {
				accountNo = (String) creditCardFrame.model.getValueAt(
						currentSelection, 1);
				TransactionFrame deposit = new DepositFrame(
						creditCardFrame, "Deposit", accountNo);
				currentActiveFrame = deposit;
				deposit.setVisible(true);
			}
		}

	}

	class ChargeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentSelection = creditCardFrame.JTable1.getSelectionModel()
					.getMinSelectionIndex();
			if (currentSelection >= 0) {
				accountNo = (String) creditCardFrame.model.getValueAt(
						currentSelection, 1);
				ChargeFrame charge = new ChargeFrame(creditCardFrame,
						"Charge Credit Card Frame", accountNo);
				currentActiveFrame = charge;
				charge.setVisible(true);
			}
		}

	}

	class AddInterestListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			creditCardApplication.addInterest();
			JOptionPane.showMessageDialog(creditCardFrame,
					"Intersest added to all accounts", "",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	class AddAccountOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String[] fields = addAccountFrame.getAccountInfo();
			IAddress address = new Address(fields[1], fields[2], fields[3],
					fields[4]);

			creditCardApplication.addAccount(fields[0], address, null, fields[5],
					accountType, "P", fields[6], fields[7]);
			// fields[0], addr, fields[5], fields[6], accountType, "P",
			// null,fields[7]
			/*
			 * fields[0] = JTextField_NAME.getText(); fields[1] =
			 * JTextField_STR.getText(); fields[2] = JTextField_CT.getText();
			 * fields[3] = JTextField_ST.getText(); fields[4] =
			 * JTextField_ZIP.getText(); fields[5] = JTextField_CCNR.getText();
			 * fields[6] = JTextField_ExpDate.getText();
			 * fields[7]=JTextField_Email.getText();
			 */
			String[] rowdata = new String[8];
			rowdata[0] = fields[0];
			rowdata[1] = fields[5];
			rowdata[2] = fields[6];
			rowdata[3] = accountType;
			rowdata[4] = "0.0";
			rowdata[5] = accountType;
			rowdata[6] = "0.0";
			rowdata[7] = fields[6];
			creditCardFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);

		}

	}

	class ChargeOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Double amount = Double.parseDouble(chargeFrame.getAmount()
					.toString());
			IRule withdrawPredicate = new CreditCardPredicate(amount);
			boolean isCharged = creditCardApplication.charge(accountNo, amount,
					withdrawPredicate);
			Double currentBalance = Double.parseDouble(creditCardFrame.model
					.getValueAt(currentSelection, 4).toString());
			Double newValue = currentBalance - amount;
			if (isCharged) {
				creditCardFrame.model.setValueAt(newValue, currentSelection, 4);
				JOptionPane.showMessageDialog(creditCardFrame,
						"Account Charged successfully ", "",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(creditCardFrame,
						"You don't have sufficient balance ", "",
						JOptionPane.PLAIN_MESSAGE);
			}
			currentActiveFrame.setVisible(false);

		}
	}

	class DepositOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// String test= depositFrame.getAmount();
			// System.out.println("Hey="+test);
			double amount = Double.parseDouble(depositFrame.getAmount()
					.toString());
			// System.out.println("Amount is " + amount);
			IRule deposit = new CreditCardPredicate(amount);
			double newAmount = creditCardApplication.deposit(accountNo, amount,
					deposit);

			// here
			System.out.println("here----" + newAmount);
			creditCardFrame.model.setValueAt(newAmount, currentSelection, 4);
			JOptionPane
					.showMessageDialog(creditCardFrame,
							"You have successfully Deposited " + amount
									+ " to your account", "",
							JOptionPane.PLAIN_MESSAGE);
			currentActiveFrame.setVisible(false);

		}
	}

	class GoldBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = "Gold";
		}
	}

	class BronzeBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = "Bronze";
		}
	}

	class SilverBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = "Silver";
		}
	}

	public ActionListener getNewCreditCardAccountListener(MainFrame frame) {

		return new NewAccountListener();

	}

	public ActionListener getGenerateBillListener(MainFrame frame) {
		return new GenerateBillListener();

	}

	public ActionListener getChargeListener(MainFrame frame) {

		return new ChargeListener();

	}

	public ActionListener getAddInterestListener(MainFrame frame) {
		return new AddInterestListener();

	}

	public ActionListener getDepositListener(MainFrame frame) {

		return new DepositListener();

	}

	public ActionListener getAddCreditCardAccountOkListener(
			AddAccountFrame frame) {
		addAccountFrame = frame;
		return new AddAccountOKListener();

	}

	public ActionListener getChargeOKListener(ChargeFrame frame) {
		chargeFrame = frame;
		return new ChargeOKListener();
	}

	public ActionListener getDepositOKListener(DepositFrame frame) {
		depositFrame = frame;
		return new DepositOKListener();
	}

	public java.awt.event.MouseListener getGoldBoxListener() {
		return new GoldBoxListener();
	}

	public java.awt.event.MouseListener getSilverBoxListener() {
		return new SilverBoxListener();
	}

	public java.awt.event.MouseListener getBronzeBoxListener() {
		return new BronzeBoxListener();
	}

	public void setCreditcardProcessor(CreditcardApplication creditcardProcessor) {
		this.creditCardApplication = creditcardProcessor;
	}

	CreditcardApplication getCreditcardProcessor() {
		return creditCardApplication;
	}

	public void setCreditcardForm(CreditcardFrame creditcardForm) {
		this.creditCardFrame = creditcardForm;
	}

	public CreditcardFrame getCreditcardForm() {
		return creditCardFrame;
	}

}
