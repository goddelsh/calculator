package ru.testproject.calculator;

import ru.testproject.calculator.input.*;
import ru.testproject.calculator.logic.Calculate;

public class CalculatorUI {
    void init(Input input, Calculate action){
        boolean active = true;
        this.showRules();
        while(active){
            String result = action.action(input, "ask smth");
            System.out.println(result);
        }
    }

    private void showRules() {
        System.out.println("bla bla bla");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Calculate calc = new Calculate();
        new CalculatorUI().init(input, calc);
    }
}
