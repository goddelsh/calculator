package ru.testproject.calculator.logic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculateExpressionTest {
    @Test
    public void testArabicExpression(){
        CalculateExpression arabicExpression = new CalculateExpression("2+10");
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ARABIC);
        assertThat(arabicExpression.getFirst(), is(2));
        assertThat(arabicExpression.getSecond(), is(10));
        assertThat(arabicExpression.getSymbol(), is("+"));
    }

    @Test
    public void testRomanExpression(){
        CalculateExpression arabicExpression = new CalculateExpression("IX*VII");
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ROMAN);
        assertThat(arabicExpression.getFirst(), is(9));
        assertThat(arabicExpression.getSecond(), is(7));
        assertThat(arabicExpression.getSymbol(), is("*"));
    }

}
