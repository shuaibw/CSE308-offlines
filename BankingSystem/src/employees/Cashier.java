package employees;

public class Cashier extends Employee {
    public Cashier(String name) {
        super(name);
    }
    @Override
    public void approveLoanRequests() {
        System.out.println("You don't have permission for this operation");
    }
}
