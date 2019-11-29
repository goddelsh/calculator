package ru.testproject.calculator.logic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DigitsTypeTest {
    @Test
    public void textWithArabicDigitsParse(){
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ARABIC);
        String[] text = {"5","1","3","10"};
        Integer result = 0;
        for(int index = 0; index < text.length; index++){
            result += DigitsType.parse(text[index]);
        }
        assertThat(result, is(19));
    }

    @Test
    public void textWithRomanDigitsParse(){
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ROMAN);
        String[] text = {"V","I","III","X"};
        Integer result = 0;
        for(int index = 0; index < text.length; index++){
            result += DigitsType.parse(text[index]);
        }
        assertThat(result, is(19));
    }

    @Test(expected = IllegalStateException.class)
    public void textWithoutDigitsStyleParse(){
        DigitsType digitsType = new DigitsType();
        String[] text = {"V","I","III","X"};
        Integer result = 0;
        for(int index = 0; index < text.length; index++){
            result += DigitsType.parse(text[index]);
        }
    }

    @Test
    public void textWithArabicDigitsConvert(){
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ARABIC);
        Integer[] text = {5,1,3,10};
        String result = "";
        for(int index = 0; index < text.length; index++){
            result += DigitsType.convert(text[index]);
        }
        assertThat(result, is("51310"));
    }

    @Test
    public void textWithRomanDigitsConvert(){
        DigitsType digitsType = new DigitsType();
        digitsType.setDigitStyle(DigitStyle.ROMAN);
        Integer[] text = {5,1,3,10};
        String result = "";
        for(int index = 0; index < text.length; index++){
            result += DigitsType.convert(text[index]);
        }
        assertThat(result, is("VIIIIX"));
    }

    @Test(expected = IllegalStateException.class)
    public void textWithoutDigitsStyleConvert(){
        DigitsType digitsType = new DigitsType();
        Integer[] text = {5,1,3,10};
        String result = "";
        for(int index = 0; index < text.length; index++){
            result += DigitsType.convert(text[index]);
        }
    }
}
