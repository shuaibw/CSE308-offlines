public class StudentAccount extends Account {
    private static final double MAX_ALLOWED_LOAN = 1000;
    private static final double MAX_WITHDRAW_LIMIT = 10000;
    private static double INTEREST_RATE = 0.05;

    public StudentAccount(String name, AccountType type, double initialDeposit) {
        super(name, type, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0 || amount >= MAX_WITHDRAW_LIMIT || amount > getCurrentBalance()) {
            System.out.printf("Invalid transaction, current balance: %.2f\n", getCurrentBalance());
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

    @Override
    public void updateInterest() {
        double interestProfit = INTEREST_RATE * getCurrentBalance();
        double interestExpense = Account.getLoanInterestRate() * getCurrentLoan();
        double netChange = interestProfit - interestExpense - getServiceCharge();
        setCurrentBalance(getCurrentBalance() + netChange);
        double currentBalance = getCurrentBalance();
        if (currentBalance < 0) {
            setCurrentLoan(getCurrentLoan() + Math.abs(currentBalance));
            setCurrentBalance(0);
            System.out.printf("Insufficient balance for %s. Charge added to loan, current loan: %.2f\n", getName(), getCurrentLoan());
        }
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    public static void setInterestRate(double interestRate) {
        INTEREST_RATE = interestRate;
    }

}
