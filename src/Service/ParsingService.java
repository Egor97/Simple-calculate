package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingService {

    public List<Double> parsingOperand(String arithmeticExpression) {

        List<Double> listOperand = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+\\.?\\d?");
        Matcher matcher = pattern.matcher(arithmeticExpression);

        while (matcher.find()) {
            listOperand.add(Double.valueOf(matcher.group()));
        }

        return listOperand;
    }

    List<CharSequence> parsingOperationSign(String arithmeticExpression) {

        List<CharSequence> listSign = new ArrayList<>();

        Pattern pattern = Pattern.compile("[\\-+/*]");
        Matcher matcher = pattern.matcher(arithmeticExpression);

        while (matcher.find()) {
            listSign.add(matcher.group());
        }

        return listSign;
    }
}
