abstract class Account {
    private final String name;
    private static final double LOAN_INTEREST_RATE = 0.1;
    private double serviceCharge = 500;
    private int year;
    private final AccountType type;
    private double currentBalance = 0;
    private double currentLoan = 0;

    public Account(String name, AccountType type, double initialDeposit) {
        this.type = type;
        this.name = name;
        if (type == AccountType.LOAN) {
            this.currentLoan = initialDeposit;
            serviceCharge = 0;
        } else {
            this.currentBalance = initialDeposit;
        }
        year = 0;
    }

    public abstract void withdraw(double amount);

    public abstract void requestLoan(double amount);

    public void query() {
        System.out.printf("Current balance %.2f$, loan %.2f$\n", currentBalance, currentLoan);
    }

    public void deposit(double amount) {
        if (amount <= 0) System.out.println("Cannot deposit 0$ or less");
        else {
            currentBalance += amount;
            System.out.printf("%.2f$ deposited; current balance %.2f$\n", amount, currentBalance);
        }
    }

    public static double getLoanInterestRate(){
        return LOAN_INTEREST_RATE;
    }


    public String getName() {
        return name;
    }

    public AccountType getType() {
        return type;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getCurrentLoan() {
        return currentLoan;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setCurrentLoan(double currentLoan) {
        this.currentLoan = currentLoan;
    }

    public void tickYear() {
        year++;
    }

    public int getYear() {
        return year;
    }

    public abstract void updateInterest();

    public void printCreationMessage() {
        System.out.printf("%s account for %s created; initial balance %.2f$\n", type, name, currentBalance);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome, " + name);
    }

    public void printCloseMessage() {
        System.out.println("Transactions closed for " + name);
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        return name.equals(account.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
