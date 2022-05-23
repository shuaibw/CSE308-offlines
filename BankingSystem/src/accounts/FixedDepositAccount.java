package accounts;

import bank.Bank;
import util.AccountType;
import util.LoanRequest;

public class FixedDepositAccount extends Account {
    private static final double MAX_ALLOWED_LOAN = 100000;
    private static final double MIN_DEPOSIT_AMOUNT = 50000;
    private static double INTEREST_RATE = 0.15;
    public FixedDepositAccount(String name, AccountType type, double initialDeposit) {
        super(name, type, initialDeposit);
    }
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Cannot deposit 0$ or less");
        } else if (amount < MIN_DEPOSIT_AMOUNT) {
            System.out.println("ERROR: Minimum 50000$ deposit for fixed deposit accounts");
        } else {
            setCurrentBalance(getCurrentBalance() + amount);
            System.out.printf("%.2f$ deposited; current balance %.2f$\n", amount, getCurrentBalance());
        }
    }

    @Override
    public void withdraw(double amount) {
        if (getYear() < 1) {
            System.out.println("Account has not reached maturity");
        } else if (amount > getCurrentBalance()) {
            System.out.printf("Invalid transaction, current balance: %.2f$\n", getCurrentBalance());
        } else {
            setCurrentBalance(getCurrentBalance() - amount);
            System.out.printf("Withdraw success, current balance: %.2f\n", getCurrentBalance());
        }
    }

    @Override
    public void requestLoan(double amount) {
        if (amount <= MAX_ALLOWED_LOAN) {
            Bank.getInstance().getLoanReqLists().add(new LoanRequest(this, amount));
            System.out.println("Loan request successful, sent for approval");
        }
        else System.out.printf("Loan amount must be less than %.2f$\n", MAX_ALLOWED_LOAN);
    }
    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public static void setInterestRate(double interestRate) {
        INTEREST_RATE = interestRate;
    }
}
