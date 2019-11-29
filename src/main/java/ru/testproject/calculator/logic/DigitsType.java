package ru.testproject.calculator.logic;

public class DigitsType {
    public static DigitsType digitsType = new DigitsType();

    public DigitStyle digitStyle = null;

    public DigitStyle getDigitStyle() {
        return digitsType.digitStyle;
    }

    public void setDigitStyle(DigitStyle digitStyle) {
        digitsType.digitStyle = digitStyle;
    }

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
            throw new IllegalStateException("without digit type");
        }
        return result;
    }

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
            throw new IllegalStateException("without digit type");
        }
        return result;
    }



    private static Integer parseArabic(String number){
        Integer result = Integer.parseInt(number);
        return result;
    }

    private static Integer parseRome(String number){
        Integer result = 0;
        int pos = 0;

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


/*
       Integer romeIndex = RomanNumerals.values().length - 1;
        while(romeIndex >= 0 && pos < number.length()){
            Integer romanElementLength = RomanNumerals.values()[romeIndex].getAlias().length();
            System.out.println(number.substring(pos, romanElementLength));
            if((romanElementLength <= number.length())&&(number.substring(pos, romanElementLength).contains(RomanNumerals.values()[romeIndex].getAlias()))){
                result += RomanNumerals.values()[romeIndex].getValue();
                pos += RomanNumerals.values()[romeIndex].getAlias().length();
            }else{
                romeIndex--;
            }
        }
*/


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
