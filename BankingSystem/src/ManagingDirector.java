import java.util.Locale;
import java.util.Scanner;

public class ManagingDirector extends Employee {
    public ManagingDirector(String name) {
        super(name);
    }

    @Override
    public void seeInternalFund() {
        Bank bank = Bank.getInstance();
        System.out.printf("Internal fund for bank: %.2f\n", bank.getInternalFund());
    }

    @Override
    public void changeInterestRate(AccountType type, double newInterestRate) {
        double interestRate = newInterestRate / 100;
        switch (type) {
            case LOAN -> LoanAccount.setInterestRate(interestRate);
            case SAVINGS -> SavingsAccount.setInterestRate(interestRate);
            case FIXED_DEPOSIT -> FixedDepositAccount.setInterestRate(interestRate);
            case STUDENT -> StudentAccount.setInterestRate(interestRate);
        }
        System.out.printf("Interest rate for %s changed to %.2f%%\n", type.name(), newInterestRate);
    }
}
