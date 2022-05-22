import java.util.Scanner;

public class BankSimulator {
    private static final Bank bank = Bank.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void handleMasterCommand(String cmd) {
        String[] parsed = cmd.split(" ");
        switch (parsed[0].toLowerCase()) {
            case "create" -> {
                Account created = createAccount(parsed[1], parsed[2], parsed[3]);
                if (created != null) {
                    created.printCreationMessage();
                    openAccount(parsed[1]);
                } else {
                    System.out.println("Account creation failed");
                }
            }
            case "open" -> {
                openAccount(parsed[1]);

            }
            case "inc" -> {
                incrementYear();
                System.out.println("1 year passed");
            }
            default -> System.out.println("Invalid command");
        }
    }

    private static void incrementYear() {
        bank.getAccounts().forEach((name, account) -> {
            account.tickYear();
            account.updateInterest();
        });
    }

    private static void openAccount(String name) {
        boolean isEmployee = bank.getEmployees().containsKey(name);
        boolean isCustomer = bank.getAccounts().containsKey(name);
        if (isCustomer) {
            openCustomer(bank.getAccounts().get(name));
        } else if (isEmployee) {
            openEmployee(bank.getEmployees().get(name));
        } else System.out.println("Account doesn't exist");
    }

    private static void openEmployee(Employee employee) {
        String cmd;
        employee.printWelcomeMessage();
        while (!(cmd = scanner.nextLine()).equalsIgnoreCase("close")) {
            String[] parsed = cmd.split(" ");
            switch (parsed[0].toLowerCase()) {
                case "lookup" -> employee.lookUp(parsed[1]);
                case "approve" -> employee.approveLoanRequests();
                case "change" -> employee.changeInterestRate(AccountType.valueOf(parsed[1].toUpperCase()), Double.parseDouble(parsed[2]));
                case "see" -> employee.seeInternalFund();
                default -> System.out.println("Invalid employee operation");
            }
        }
        employee.printCloseMessage();
    }

    private static void openCustomer(Account account) {
        String cmd;
        account.printWelcomeMessage();
        while (!(cmd = scanner.nextLine()).equalsIgnoreCase("close")) {
            String[] parsed = cmd.split(" ");
            switch (parsed[0].toLowerCase()) {
                case "deposit" -> account.deposit(Double.parseDouble(parsed[1]));
                case "withdraw" -> account.withdraw(Double.parseDouble(parsed[1]));
                case "request" -> account.requestLoan(Double.parseDouble(parsed[1]));
                case "query" -> account.query();
                default -> System.out.println("Invalid customer command");
            }
        }
        account.printCloseMessage();
    }

    private static Account createAccount(String name, String type, String amount) {
        AccountType accountType = AccountType.valueOf(type.toUpperCase());
        double initialAmount = Double.parseDouble(amount);
        Account account = null;
        switch (accountType) {
            case STUDENT -> account = new StudentAccount(name, accountType, initialAmount);
            case SAVINGS -> account = new SavingsAccount(name, accountType, initialAmount);
            case LOAN -> account = new LoanAccount(name, accountType, initialAmount);
            case FIXED_DEPOSIT -> {
                if (initialAmount >= 50000)
                    account = new FixedDepositAccount(name, accountType, initialAmount);
            }
        }
        if (account != null) {
            bank.getAccounts().put(name, account);
            return account;
        }
        return null;
    }
}
