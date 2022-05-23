package accounts;

import bank.Bank;
import util.AccountType;
import util.LoanRequest;

public class LoanAccount extends Account {
    private static final double MAX_ALLOWED_LOAN_PERCENT = 5;
    private static double INTEREST_RATE = 0.0;

    public LoanAccount(String name, AccountType type, double initialDeposit) {
        super(name, type, initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Cannot deposit 0$ or less");
        } else if (amount <= getCurrentLoan()) {
            setCurrentLoan(getCurrentLoan() - amount);
            System.out.printf("%.2f$ deposited; current loan %.2f$\n", amount, getCurrentLoan());
        } else {
            setCurrentBalance(amount - getCurrentLoan());
            setCurrentLoan(0);
            System.out.printf("%.2f$ deposited; current balance %.2f$, current loan %.2f$\n", amount, getCurrentBalance(), getCurrentLoan());
        }
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public static void setInterestRate(double interestRate) {
        INTEREST_RATE = interestRate;
    }

    @Override
    public void requestLoan(double amount) {
        double maxAllowableLoan = (MAX_ALLOWED_LOAN_PERCENT / 100) * getCurrentLoan();
        if (amount <= maxAllowableLoan) {
            Bank.getInstance().getLoanReqLists().add(new LoanRequest(this, amount));
            System.out.println("Loan request successful, sent for approval");
        } else {
            System.out.printf("ERROR: Requested loan must be less than 5%% of your current loan, which is %.2f$\n", maxAllowableLoan);
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Unsupported operation for loan account");
    }

    @Override
    public void printCreationMessage() {
        System.out.printf("%s account for %s created; initial loan %.2f$\n", getType(), getName(), getCurrentLoan());
    }
}
