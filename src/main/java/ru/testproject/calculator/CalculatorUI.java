package ru.testproject.calculator;

import ru.testproject.calculator.input.*;
import ru.testproject.calculator.logic.*;
import ru.testproject.calculator.other.*;

public class CalculatorUI {
    void init(Input input, Calculate action){
        boolean active = true;
        this.showRules();
        while(active){
            String result;
            try{
                result = action.action(input, Constants.tryText);
            }catch(IllegalStateException ex){
                result = ex.getLocalizedMessage();
            }catch(QuitException quit){
                active = false;
                result = quit.toString();
            }

            System.out.println(result);
        }
    }

    private void showRules() {
        System.out.println(Constants.mainText);
        System.out.println(Constants.ruleText);
        System.out.println(Constants.exampleText);
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        ValidateExpressionInput validateInput = new ValidateExpressionInput(input);
        Calculate calc = new Calculate();
        //DigitsType digitsType = new DigitsType();
      //I  digitsType.setDigitStyle(DigitStyle.ARABIC);
       // digitsType.setDigitStyle(DigitStyle.ROMAN);
        new CalculatorUI().init(validateInput, calc);
    }
}
