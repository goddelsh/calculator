package ru.testproject.calculator.logic;

import ru.testproject.calculator.input.Input;
import ru.testproject.calculator.other.*;

public class Calculate {
    public String action(Input input, String message) throws IllegalStateException, QuitException{
        Integer result =  null;
        CalculateExpression inputExpression = new CalculateExpression(input.askExpression(message));
        switch (inputExpression.getSymbol()) {
            case Constants.PLUS:
                result = inputExpression.getFirst() + inputExpression.getSecond();
                break;
            case Constants.MINUS:
                result = inputExpression.getFirst() - inputExpression.getSecond();
                break;
            case Constants.MULTIPLY:
                result = inputExpression.getFirst() * inputExpression.getSecond();
                break;
            case Constants.DEVIDE:
                result = inputExpression.getFirst() / inputExpression.getSecond();
                break;
            default:
                throw new IllegalStateException("Unknown symbol");
        }
        return DigitsType.convert(result);
    }
}
