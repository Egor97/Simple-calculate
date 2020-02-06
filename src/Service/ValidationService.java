package Service;

import Exception.InvalidExpressionException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {

    private ConsoleService consoleService = new ConsoleService();
    private ParsingService parsingService = new ParsingService();

    private String arithmeticExpression = consoleService.consoleReceivingArithmeticExpression();

    private void checkForEmptyField(String theResultingExpression) {
        if (theResultingExpression.trim().equals("")) {
            throw new InvalidExpressionException("You have entered an empty field");
        }
    }

    private void checkForNegativeNumber(String theResultingExpression) {
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("You have entered negative number");
        }
    }

    private void checkingLettersInAnExpression(String theResultingExpression) {
        Pattern pattern = Pattern.compile(".*?[a-zA-Z].*?");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("You have entered expression with letter");
        }
    }

    private void checkingRepetitionSign(String theResultingExpression) {
        Pattern pattern = Pattern.compile("[-+/*]{2,}");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("You have entered an expression with a repeating math sign");
        }
    }

    private void checkingOnRepeatDot(String theResultingExpression) {
        Pattern pattern = Pattern.compile("[\\.]{2,}");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("You have entered an expression with a repeating dot in the real number");
        }
    }

    private void zeroCheck(String theResultingExpression) {
        Pattern pattern = Pattern.compile(".*[/]\\s?[0]");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("You have entered expression with division by zero");
        }
    }

    private void firstSymbolLineIsSignCheck(String theResultingExpression) {
        Pattern pattern = Pattern.compile("^[\\s]?[\\D]");
        Matcher matcher = pattern.matcher(theResultingExpression);

        if (matcher.find()) {
            throw new InvalidExpressionException("The string of the entered expression begins with the arithmetic sign");
        }
    }

    private List<CharSequence> arithmeticSignCheck(List<CharSequence> operationSign) {

        Pattern pattern =  Pattern.compile("[-|+|*|/]");
        Matcher matcher = pattern.matcher(operationSign.toString());

        if (!matcher.find()) {
            throw new InvalidExpressionException("You have entered an invalid sign");
        }

        return operationSign;
    }

    public String checkingOnValidArithmeticExpression() {
        checkForEmptyField(arithmeticExpression);
        checkForNegativeNumber(arithmeticExpression);
        zeroCheck(arithmeticExpression);
        checkingLettersInAnExpression(arithmeticExpression);
        checkingRepetitionSign(arithmeticExpression);
        checkingOnRepeatDot(arithmeticExpression);
        firstSymbolLineIsSignCheck(arithmeticExpression);

        return arithmeticExpression;
    }

    public List<CharSequence> arithmeticSignCheck() {
        return arithmeticSignCheck(parsingService.parsingOperationSign(arithmeticExpression));
    }
}
