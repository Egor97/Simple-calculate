package Entity;

import Service.ArithmeticCalculationService;
import Service.ConsoleService;
import Service.ParsingService;
import Service.ValidationService;

import java.util.List;

public class ExpressionEntity {

    private ConsoleService consoleService = new ConsoleService();
    private ValidationService validationService = new ValidationService();
    private ParsingService parsingService = new ParsingService();
    private ArithmeticCalculationService arithmeticCalculationService = new ArithmeticCalculationService();

    private String arithmeticExpressionFromConsole = consoleService.getArithmeticExpressionFromConsole();

    private String arithmeticExpression = validationService.checkingOnValidArithmeticExpression(arithmeticExpressionFromConsole);

    private List<Double> operand = parsingService.parsingOperand(arithmeticExpression);
    private List<CharSequence> operationSign = validationService.arithmeticSignCheck(arithmeticExpression);

    private double arithmeticResult = arithmeticCalculationService.calcExpression(operand, operationSign);

    public double getArithmeticResult() { return arithmeticResult; }
    public String getArithmeticExpressionFromConsole() { return arithmeticExpressionFromConsole; }
}
