package creditcard.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import creditcard.controller.CreditCardController;
import creditcard.view.CreditcardFrame;
import framework.model.FinancialCompany;
import framework.externalInterfaces.IAccount;
import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.IRule;

public class CreditcardApplication extends FinancialCompany {
    // List<IAccount> bankAccounts = new LinkedList<IAccount>();

    ICustomer cust;
    IAccount acct;
    IRule predicate;

    public void addAccount(String name, IAddress address, String value,
            String acctNo, String acctType, String custType, String expDate,
            String email) {

        CreditCardFactory factory = new CreditCardFactory();
        cust = factory.createCustomer(name, custType, address, email, value);
        super.customerList.add(cust);

        acct = factory.createAccount(cust, acctNo, acctType, expDate);

        super.accountList.add(acct);

    }

    public double deposit(String accnr, double amount, IRule depositRule) {
        // deposit
        predicate = depositRule;
        acct = getAccount(accnr);
        System.out.println(accnr);
        if (acct.getAccountOwner().getCustomerType().equals("P")) {
            if (predicate.isGreaterThanLimit()) {
              //  notifyCustomer();

            } else {
                acct.deposit(amount);

            }
        }
        return acct.getBalance();

    }

    public void addInterest(IAccount acct) {
        super.addInterest();
    }

    public boolean charge(String accnr, double amount,
            IRule withdrawPredicate) {
        // withdraw
        predicate = withdrawPredicate;
        acct = getAccount(accnr); // searching an account from our list
        double incomingAmount = amount;
        double balance = acct.getBalance();
        amount = amount * -1;
        if (acct.getAccountOwner().getCustomerType().equals("P")) {
            if (predicate.isGreaterThanLimit() || balance < incomingAmount) {
                super.setEmailNotification("Charge Transaction Cancelled! Your balance either too low or your requested amount is more than the charge Limit");
              //  notifyCustomer();
                return false;
            } else {
                acct.deposit(amount);
                return true;
            }
        } // if company account notify them
        else {
            acct.deposit(amount);
            super.setEmailNotification("Charge tansaction completed");
            //super.notifyCustomer();
            return true;

        }

    }

    public List<String[]> generateReport() {
        List<String[]> report = new ArrayList<String[]>();
        Iterator<IAccount> it = super.accountList.iterator();
        IAccount acct;
        while (it.hasNext()) {
            acct = it.next();
            report.add(acct.generateReport());

        }

        return report;
    }

    private IAccount getAccount(String acctno) {
        for (IAccount acc : super.accountList) {
            if (acc.getAcctNumber().equals(acctno)) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CreditcardApplication creditCardProcessingSystem = new CreditcardApplication();
        CreditCardController control = CreditCardController.getInstance();
        control.setCreditcardProcessor(creditCardProcessingSystem);
        CreditcardFrame mainFrame = new CreditcardFrame(
                "Creditcard processing Application");
        control.setCreditcardForm(mainFrame);

        mainFrame.setVisible(true);
    }
}
