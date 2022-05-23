import bank.BankSimulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSimulator simulator=new BankSimulator();
        String cmd;
        Scanner scanner = new Scanner(System.in);
        while (!(cmd = scanner.nextLine()).equalsIgnoreCase("exit")) {
            try {
                BankSimulator.handleMasterCommand(cmd);
            } catch (Exception e) {
                System.out.println("Invalid operation");
            }
        }
    }
}
