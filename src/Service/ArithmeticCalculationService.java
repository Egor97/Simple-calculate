package Service;

import java.util.List;

public class ArithmeticCalculationService {

    public double calcExpression(List<Double> operand, List<CharSequence> operationSign) {

        double firstNumber;
        double secondNumber;
        double sum = 0;
        int indexSignInList;

        while (operationSign.contains("/")) {
            indexSignInList = operationSign.indexOf("/");

            firstNumber = operand.get(indexSignInList);
            secondNumber = operand.get(indexSignInList + 1);

            sum = firstNumber / secondNumber;

            deleteElementsFromLists(operand, operationSign, indexSignInList, sum);
        }

        while (operationSign.contains("*")) {
            indexSignInList = operationSign.indexOf("*");

            firstNumber = operand.get(indexSignInList);
            secondNumber = operand.get(indexSignInList + 1);

            sum = firstNumber * secondNumber;

            deleteElementsFromLists(operand, operationSign, indexSignInList, sum);
        }

        while (operationSign.contains("-")) {
            indexSignInList = operationSign.indexOf("-");

            firstNumber = operand.get(indexSignInList);
            secondNumber = operand.get(indexSignInList + 1);

            sum = firstNumber - secondNumber;

            deleteElementsFromLists(operand, operationSign, indexSignInList, sum);
        }

        while (operationSign.contains("+")) {
            indexSignInList = operationSign.indexOf("+");

            firstNumber = operand.get(indexSignInList);
            secondNumber = operand.get(indexSignInList + 1);

            sum = firstNumber + secondNumber;

            deleteElementsFromLists(operand, operationSign, indexSignInList, sum);
        }

        return sum;
    }

    private void deleteElementsFromLists(List<Double> operand, List<CharSequence> operationSign,
                                        int indexSignInList, double sum) {
        operationSign.remove(indexSignInList);
        operand.remove(indexSignInList);
        operand.remove(indexSignInList);
        operand.add(indexSignInList, sum);
    }
}
