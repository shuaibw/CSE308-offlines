package syntax;

import syntax.singleton.Editor;

import java.util.Scanner;

public class SyntaxDemo {
    public static void runDemo() {
        Scanner scanner = new Scanner(System.in);
        String file;
        while (!(file = scanner.nextLine()).equalsIgnoreCase("exit")) {
            System.out.println("Enter file name");
            Editor.getInstance().openFile(file);
        }
    }
}
