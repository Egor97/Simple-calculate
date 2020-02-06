package Service;

import java.util.Scanner;

import static java.lang.System.out;

class ConsoleService {

    String consoleReceivingArithmeticExpression() {
        out.print("Arithmetic Expression: ");
        Scanner scanner = new Scanner(System.in);

        String arithmeticExpression = scanner.nextLine();

        scanner.close();

        return arithmeticExpression;
    }

}
