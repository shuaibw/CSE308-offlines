package qms;

import qms.builder.Director;
import qms.builder.QMSBuilder;
import qms.product.QMS;

import java.util.Scanner;

public class QMSDemo {
    public static void runDemo() {
        String cmd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: [package] [count] [communication channel]");
        while (!(cmd = scanner.nextLine()).equalsIgnoreCase("exit")) {
            System.out.println("***Queue Management System***");
            String[] parts = cmd.split(" ");
            String packName = parts[0];
            int displayCount = Integer.parseInt(parts[1]);
            String commChannel = parts[2];
            QMSBuilder builder = new QMSBuilder();
            Director director = new Director(builder);
            director.construct(packName, displayCount, commChannel);
            QMS qms = builder.getSystem();
            qms.printSystemDescription();
            System.out.println("Total cost: " + qms.getCost());
            System.out.println("Enter: [package] [count] [communication channel]");
        }

    }
}
