package ru.testproject.calculator.logic;

import ru.testproject.calculator.input.Input;

public class Calculate {
    public String action(Input input, String message){
        Integer result =  null;
        CalculateExpression inputExpression = new CalculateExpression(input.askExpression(message));
        switch (inputExpression.getSymbol()) {
            case "+":
                result = inputExpression.getFirst() + inputExpression.getSecond();
                break;
            case "-":
                result = inputExpression.getFirst() - inputExpression.getSecond();
                break;
            case "*":
                result = inputExpression.getFirst() * inputExpression.getSecond();
                break;
            case "/":
                result = inputExpression.getFirst() / inputExpression.getSecond();
                break;
            default:
                throw new IllegalStateException("Unknown symbol");
        }
        return DigitsType.convert(result);
    }
}
