package bank;

import accounts.*;
import employees.Cashier;
import employees.Employee;
import employees.ManagingDirector;
import employees.Officer;
import util.LoanRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private final HashMap<String, Employee> employees;
    private final HashMap<String, Account> accounts;
    private final ArrayList<LoanRequest> loanReqLists;
    private double internalFund;
    private static Bank bank;

    private Bank() {
        internalFund = 1000000;
        employees = new HashMap<>();
        accounts = new HashMap<>();
        loanReqLists = new ArrayList<>();
        Employee o1 = new Officer("O1");
        Employee o2 = new Officer("O2");
        Employee md = new ManagingDirector("MD");
        Employee c1 = new Cashier("C1");
        Employee c2 = new Cashier("C2");
        Employee c3 = new Cashier("C3");
        Employee c4 = new Cashier("C4");
        Employee c5 = new Cashier("C5");
        employees.put(o1.getName(), o1);
        employees.put(o2.getName(), o2);
        employees.put(md.getName(), md);
        employees.put(c1.getName(), c1);
        employees.put(c2.getName(), c2);
        employees.put(c3.getName(), c3);
        employees.put(c4.getName(), c4);
        employees.put(c5.getName(), c5);
        StringBuilder sb = new StringBuilder();
        sb.append("Bank created: ");
        ArrayList<String> empList = new ArrayList<>(employees.keySet());
        empList.sort(String::compareToIgnoreCase);
        empList.forEach(emp -> sb.append(emp).append(", "));
        sb.setLength(sb.length() - 2);
        sb.append(" created");
        System.out.println(sb);
    }

    public static Bank getInstance() {
        if (bank == null) bank = new Bank();
        return bank;
    }

    public HashMap<String, Employee> getEmployees() {
        return employees;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public ArrayList<LoanRequest> getLoanReqLists() {
        return loanReqLists;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void setInternalFund(double fund) {
        internalFund = fund;
    }
}
