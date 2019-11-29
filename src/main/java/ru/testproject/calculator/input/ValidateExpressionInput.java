package ru.testproject.calculator.input;

import java.util.regex.Pattern;
import ru.testproject.calculator.other.*;
import ru.testproject.calculator.logic.*;

public class ValidateExpressionInput implements Input {
    private Input input;
    private DigitsType digitsType = new DigitsType();


    public ValidateExpressionInput(Input input){
        this.input = input;
    }

    public String askExpression(String question) throws QuitException {
        return validateExpression(input.askExpression(question));
    }

    private String validateExpression(String expression) throws QuitException {
        if(expression.contains(Constants.EXIT)){
            throw new QuitException();
        }
        String result;
        Pattern arabicPattern = Pattern.compile(Constants.ARABIC_REGEX);
        Pattern romanPattern = Pattern.compile(Constants.ROMAN_REGEX);
        if(arabicPattern.matcher(expression).matches()){
            result = expression;
            digitsType.setDigitStyle(DigitStyle.ARABIC);
        }else if (romanPattern.matcher(expression).matches()) {
            result = expression;
            digitsType.setDigitStyle(DigitStyle.ROMAN);
        }else{
            throw new IllegalStateException(Constants.ERROR_incorrectExpression);
        }
        return result;
    }
}
