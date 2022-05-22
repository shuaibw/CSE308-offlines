import java.util.Scanner;

abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void seeInternalFund() {
        System.out.println("You don't have permission to see internal fund");
    }

    public void approveLoanRequests() {
        System.out.println("Showing currently pending loan requests. Type [approve name] to approve corresponding loan");
        System.out.println("When done, enter [done] to go back to other operations");
        Bank bank = Bank.getInstance();
        String cmd;
        Scanner scanner = new Scanner(System.in);
        while (!bank.getLoanReqLists().isEmpty()) {
            printPendingLoanRequests(bank);
            cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("done")) break;
            String[] parsed = cmd.split(" ");
            handleApprovalAction(bank, parsed);
        }
        if(bank.getLoanReqLists().isEmpty()) System.out.println("No more requests pending");
        System.out.println("Exiting loan request approval session");
    }

    private void handleApprovalAction(Bank bank, String[] parsed) {
        if (!"approve".equalsIgnoreCase(parsed[0])) {
            System.out.println("Invalid loan approval command");
            return;
        }
        String name = parsed[1];
        LoanRequest req = bank.getLoanReqLists()
                .stream()
                .filter(r -> r.account.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (req != null) {
            Account account = req.account;
            double currentLoan = account.getCurrentLoan();
            double requestedLoan = req.requestedLoan;
            account.setCurrentLoan(currentLoan + requestedLoan);
            if (requestedLoan > bank.getInternalFund()) {
                System.out.println("Not enough fund in bank");
                return;
            }
            bank.setInternalFund(bank.getInternalFund() - requestedLoan);
            bank.getLoanReqLists().remove(req);
            System.out.printf("Loan for %s approved\n", name);
        } else {
            System.out.println("Cannot find such account");
        }
    }

    private void printPendingLoanRequests(Bank bank) {
        bank.getLoanReqLists().forEach(req -> {
            Account account = req.account;
            String name = account.getName();
            AccountType type = account.getType();
            double currentLoan = account.getCurrentLoan();
            double requestedLoan = req.requestedLoan;
            System.out.printf("Account: %s, type: %s, current loan: %.2f, requested loan: %.2f\n", name, type.name(), currentLoan, requestedLoan);
        });
    }

    public void changeInterestRate(AccountType type, double newInterestRate) {
        System.out.println("You don't have permission to perform this action");
    }

    public void lookUp(String name) {
        Bank bank = Bank.getInstance();
        Account account = bank.getAccounts().get(name);
        if (account != null) {
            System.out.printf("%s's current balance: %.2f$, loan: %.2f$\n", account.getName(), account.getCurrentBalance(), account.getCurrentLoan());
        } else {
            System.out.printf("Sorry. The account named [%s] doesn't exists\n", name);
        }
    }

    public void printWelcomeMessage() {
        System.out.println(name + " active");
    }

    public void printCloseMessage() {
        System.out.println("Operations closed for " + name);
    }
}
