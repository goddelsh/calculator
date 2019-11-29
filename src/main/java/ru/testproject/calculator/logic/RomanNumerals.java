package ru.testproject.calculator.logic;

public enum RomanNumerals {
    I("I", 1), IV("IV", 4), V("V", 5), IX("IX", 9), X("X", 10), XL("XL", 40),
    L("L", 50), XC("XC", 90), C("C", 100);

    private String alias;
    private Integer value;

    RomanNumerals(String alias, Integer value){
        this.alias = alias;
        this.value = value;
    }

    Integer getValue(){
        return this.value;
    }

    String getAlias(){
        return this.alias;
    }
}
