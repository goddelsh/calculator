package ru.testproject.calculator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.testproject.calculator.input.*;
import ru.testproject.calculator.logic.Calculate;
import ru.testproject.calculator.other.Constants;

public class CalculatorUITest {
    @Test
    public void summAriphmeticExpression(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        TestInput testInput = new TestInput("q");
        ValidateExpressionInput validateInput = new ValidateExpressionInput(testInput);
        new CalculatorUI().init(validateInput,new Calculate());
        StringBuilder expect = new StringBuilder(Constants.mainText);
        expect.append(System.lineSeparator());
        expect.append(Constants.ruleText).append(System.lineSeparator());
        expect.append(Constants.exampleText).append(System.lineSeparator());
        expect.append(Constants.tryText).append(System.lineSeparator());
        //expect.append(Constants.EXIT).append(System.lineSeparator());
        expect.append(Constants.byeText).append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
