package Entity;

import Service.ArithmeticCalculationService;
import Service.ParsingService;
import Service.ValidationService;

import java.util.List;

public class ExpressionEntity {

    private ValidationService validationService = new ValidationService();
    private ParsingService parsingService = new ParsingService();
    private ArithmeticCalculationService arithmeticCalculationService = new ArithmeticCalculationService();

    private String arithmeticExpression = validationService.checkingOnValidArithmeticExpression();
    private List<Double> operand = parsingService.parsingOperand(arithmeticExpression);
    private List<CharSequence> operationSign = validationService.arithmeticSignCheck();
    private double arithmeticResult = arithmeticCalculationService.calcExpression(operand, operationSign);

    public double getArithmeticResult() { return arithmeticResult; }
}
