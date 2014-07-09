package bank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import bank.model.Bank;
import bank.model.BankPredicate;
import bank.view.AddCompanyAccountFrame;
import bank.view.AddPersonAccountFrame;
import bank.view.BankFrame;
import bank.view.DepositFrame;
import bank.view.WithdrawFrame;
import framework.model.Address;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.IRule;
import framework.view.AddAccountFrame;
import framework.view.Controller;
import framework.view.TransactionFrame;
import framework.view.ReportFrame;

public class BankController extends Controller {

	private static BankController instance;

	private BankController() {
	} //

	public static BankController getInstance() {
		if (instance == null) {
			instance = new BankController();
		}
		return instance;
	}

	private BankFrame bankFrame;
	private String acctType;
	private Bank bankApplication;
	private AddAccountFrame addAccountFrame;
	private TransactionFrame activeTranctionForm;
	private DepositFrame depositFrame;
	private WithdrawFrame withdrawFrame;
	private String accountNumber;
	private int currentSelection;

	class AddPersonAccount implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// // TODO Auto-generated method stub
			String[] fields = addAccountFrame.getAccountInfo();
			IAddress addr = new Address(fields[1], fields[2], fields[3],
					fields[4]);

			bankApplication.addAccount(fields[0], addr, fields[5], fields[6],
					acctType, "P", fields[7]);
			String[] rowdata = new String[8];
			rowdata[0] = fields[1];
			rowdata[1] = fields[2];
			rowdata[2] = fields[3];
			rowdata[3] = fields[4];
			rowdata[4] = "P";
			rowdata[5] = acctType;
			rowdata[6] = "0.0";
			rowdata[7] = fields[6];
			bankFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);
		}

	}

	class AddCompanyAccount implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			String[] fields = addAccountFrame.getAccountInfo();
			IAddress addr = new Address(fields[1], fields[2], fields[3],
					fields[4]);

			bankApplication.addAccount(fields[0], addr, fields[5], fields[6],
					acctType, "B", fields[7]);
			String[] rowdata = new String[8];
			rowdata[0] = fields[1];
			rowdata[1] = fields[2];
			rowdata[2] = fields[3];
			rowdata[3] = fields[4];
			rowdata[4] = "B";
			rowdata[5] = acctType;
			rowdata[6] = "0.0";
			rowdata[7] = fields[6];
			bankFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);
		}

	}

//	class GenerateBill implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//
//			List<String[]> report = bankApplication.generateReport();
//			ReportFrame reportFrm = new ReportFrame(bankFrame);
//			reportFrm.displayReport(report);
//			reportFrm.setVisible(true);
//		}
//
//	}

	class DepositListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentSelection = bankFrame.JTable1.getSelectionModel()
					.getMinSelectionIndex();
			if (currentSelection >= 0) {
				accountNumber = (String) bankFrame.model.getValueAt(
						currentSelection, 7);
				TransactionFrame deposit = new DepositFrame(bankFrame,
						"Deposit Frame", accountNumber);
				activeTranctionForm = deposit;
				deposit.setVisible(true);
			}

		}

	}

	class MakeWithdraw implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentSelection = bankFrame.JTable1.getSelectionModel()
					.getMinSelectionIndex();
			if (currentSelection >= 0) {
				accountNumber = (String) bankFrame.model.getValueAt(
						currentSelection, 7);
				TransactionFrame withdraw = new WithdrawFrame(bankFrame,
						"Withdraw", accountNumber);
				activeTranctionForm = withdraw;
				withdraw.setVisible(true);
			}

		}
	}

	class DepositeOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			double amount = Double.parseDouble(depositFrame.getAmount());
			System.out.println("Amount is " + amount);
			IRule rule = new BankPredicate(amount);
			double newAmount = bankApplication.deposit(accountNumber, amount,
					rule);

			// here
			System.out.println("here----" + currentSelection);
			bankFrame.model.setValueAt(newAmount, currentSelection, 6);
			JOptionPane.showMessageDialog(bankFrame, "deposited ", "",
					JOptionPane.PLAIN_MESSAGE);
			activeTranctionForm.setVisible(false);
		}

	}

	class WithDrawalOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			double amount = Double.parseDouble(withdrawFrame.getAmount());
			IRule withdrawPredicate = new BankPredicate(amount);
			boolean isWithdrawed = bankApplication.withdraw(accountNumber,
					amount, withdrawPredicate);
			Double currentBalance = Double.parseDouble(bankFrame.model
					.getValueAt(currentSelection, 6).toString());
			Double setValue = currentBalance - amount;
			if (isWithdrawed) {
				bankFrame.model.setValueAt(setValue, currentSelection, 6);
				JOptionPane.showMessageDialog(bankFrame,
						"You have successfully withdrawn " + amount
								+ " from your account", "",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane
						.showMessageDialog(
								bankFrame,
								"Transaction cancelled! \n Your balance is too low or amount requested is more than the withdraw Limit ",
								"", JOptionPane.PLAIN_MESSAGE);
			}
			activeTranctionForm.setVisible(false);
		}

	}

	class AddInterestListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			bankApplication.addInterest();
			System.out.println("interest added");
                        
			JOptionPane.showMessageDialog(bankFrame,
					"Intersest added to all accounts! ", "",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	class PersonAccountListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JDialog personalDialog = new AddPersonAccountFrame(bankFrame);
			personalDialog.setVisible(true);

		}

	}

	class CompAccountListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog buisnessDialog = new AddCompanyAccountFrame(bankFrame);
			buisnessDialog.setVisible(true);

		}

	}

	class SavingBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			acctType = "S";
		}
	}

	class CheckingBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			acctType = "C";
		}
	}

	public java.awt.event.MouseListener getSavingBoxListener() {
		return new SavingBoxListener();

	}

	public java.awt.event.MouseAdapter getCheckingBoxListener() {
		return new CheckingBoxListener();

	}

//	public ActionListener getGenerateBillListener(BankFrame frame) {
//		return new GenerateBill();
//
//	}

	public ActionListener getWithdrawListener(BankFrame frame) {
		return new MakeWithdraw();

	}

	public ActionListener getAddInterestListener(BankFrame frame) {
		return new AddInterestListener();

	}

	public ActionListener getDepositListener(BankFrame frame) {
		return new DepositListener();

	}

	public ActionListener getDepositeOKListener(DepositFrame frame) {
		depositFrame = frame;
		return new DepositeOKListener();
	}

	public ActionListener getCompanyAccountListener(BankFrame frame) {
		return new CompAccountListner();
	}

	public ActionListener getAddPersonAccountFrameOkListener(
			AddAccountFrame frame) {
		addAccountFrame = frame;
		return new AddPersonAccount();
	}

	public ActionListener getAddCompanyAccountFrameOkListener(
			AddAccountFrame frame) {
		addAccountFrame = frame;
		return new AddCompanyAccount();
	}

	// setting our bank application
	public void setbank(Bank bank) {
		this.bankApplication = bank;
	}

	public void setbankfrm(BankFrame frm) {
		bankFrame = frm;
	}

	public ActionListener getPersonAccountListener(BankFrame frame) {
		// TODO Auto-generated method stub
		return new PersonAccountListner();
	}

	public ActionListener getWithdrawOKListener(WithdrawFrame Form) {
		// TODO Auto-generated method stub
		withdrawFrame = Form;
		return new WithDrawalOKListener();
	}

}
