package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingService {

    Pattern patternOperand = Pattern.compile("\\d+\\.?\\d?");
    Pattern patternSign = Pattern.compile("[\\-+/*]");

    public List<Double> parsingOperand(String arithmeticExpression) {

        List<Double> listOperand = new ArrayList<>();

        Matcher matcher = patternOperand.matcher(arithmeticExpression);

        while (matcher.find()) {
            listOperand.add(Double.valueOf(matcher.group()));
        }

        return listOperand;
    }

    List<CharSequence> parsingOperationSign(String arithmeticExpression) {

        List<CharSequence> listSign = new ArrayList<>();

        Matcher matcher = patternSign.matcher(arithmeticExpression);

        while (matcher.find()) {
            listSign.add(matcher.group());
        }

        return listSign;
    }
}
