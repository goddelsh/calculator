package ru.testproject.calculator;

import ru.testproject.calculator.input.*;
import ru.testproject.calculator.logic.*;
import ru.testproject.calculator.other.*;

/**
 * Тестовое задание калькулятор
 * @author Ruslan Gadelshin
 * @since 29.11.2019
*/


public class CalculatorUI {
    /**
     * Метод инициализации интерфейса
     * @param input поток ввода
     * @param action обработчик
     */
    void init(Input input, Calculate action){
        boolean active = true;
        this.showRules();
        while(active){
            String result;
            try{
                result = action.action(input, Constants.tryText);
            }catch(IllegalStateException ex){
                active = false;
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
        new CalculatorUI().init(validateInput, calc);
    }
}
