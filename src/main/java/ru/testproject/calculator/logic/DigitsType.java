package ru.testproject.calculator.logic;

import ru.testproject.calculator.other.Constants;

/**
 * Класс преобразования вводимых данных в числа для операций
 */
public class DigitsType {
    /**
     * singleton для обработки стилей цифр
     */
    public static DigitsType digitsType = new DigitsType();

    public DigitStyle digitStyle = null;

    public DigitStyle getDigitStyle() {
        return digitsType.digitStyle;
    }

    public void setDigitStyle(DigitStyle digitStyle) {
        digitsType.digitStyle = digitStyle;
    }

    /**
     * Парсинг вводимых данных исходя из стиля цифр
     * @param number
     * @return
     */
    public static Integer parse(String number) {
        Integer result = -1;
        if (digitsType.digitStyle != null) {
            switch (digitsType.digitStyle) {
                case ARABIC:
                    result = parseArabic(number);
                    break;
                case ROMAN:
                    result = parseRome(number);
                    break;
                default:

            }
        }else{
            throw new IllegalStateException(Constants.ERROR_wrongDigitType);
        }
        return result;
    }

    /**
     * Конвертация результата вычеслений исходя из стиля цифр
     * @param expressionResult
     * @return
     */
    public static String convert(Integer expressionResult) {
        String result = "";
        if (digitsType.digitStyle != null) {
            switch (digitsType.digitStyle) {
                case ARABIC:
                    result = convertArabic(expressionResult);
                    break;
                case ROMAN:
                    result = convertRome(expressionResult);
                    break;
                default:

            }
        }else{
            throw new IllegalStateException(Constants.ERROR_wrongDigitType);
        }
        return result;
    }



    private static Integer parseArabic(String number){
        Integer result = Integer.parseInt(number);
        return result;
    }

    private static Integer parseRome(String number){
        Integer result = 0;
        RomanNumerals[] romanNumerals = RomanNumerals.values();
        int index = romanNumerals.length - 1;
        while((number.length() > 0)&&(index >= 0)) {
            if(number.startsWith(romanNumerals[index].getAlias())) {
                result += romanNumerals[index].getValue();
                number = number.substring(romanNumerals[index].getAlias().length());
            }else{
                index--;
            }
        }
        return result;
    }


    private static String convertArabic(Integer expressionResult){
        return String.valueOf(expressionResult);
    }

    private static String convertRome(Integer expressionResult){
        StringBuilder result = new StringBuilder("");
        Integer romanIndex = RomanNumerals.values().length - 1;
        while(expressionResult > 0){
            if (expressionResult >= RomanNumerals.values()[romanIndex].getValue()) {
                result.append(RomanNumerals.values()[romanIndex].getAlias());
                expressionResult -= RomanNumerals.values()[romanIndex].getValue();
            }else{
                romanIndex--;
            }
        }
        return result.toString();
    }
}
