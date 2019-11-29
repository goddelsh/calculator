package ru.testproject.calculator.logic;

public class CalculateExpression {
    private String symbol = null;
    private String first = "";
    private String second = "";


    public CalculateExpression(String expression){
        String[] expressionByElements = expression.split("");
        int index = 0;
        while(index < expressionByElements.length) {
            if( new String("+*/-").indexOf(expressionByElements[index]) > -1){
                symbol = expressionByElements[index];
                index++;
                continue;
            }
            if(symbol == null){
                first += expressionByElements[index];
            }else{
                second += expressionByElements[index];
            }
            index++;
        }
    }



    String getSymbol() {
        return symbol;
    }

    Integer getFirst() {
        Integer result = DigitsType.parse(first);
        if (result > 10) {
            throw new IllegalStateException("out of the maximum range");
        }
        return result;
    }

    Integer getSecond() {
        Integer result = DigitsType.parse(second);
        if (result > 10) {
            throw new IllegalStateException("out of the maximum range");
        }
        return result;
    }

}
