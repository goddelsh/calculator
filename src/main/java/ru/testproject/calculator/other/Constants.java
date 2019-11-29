package ru.testproject.calculator.other;

/**
 * Константы
 */
public class Constants {
    public static final String mainText = "Калькулятор для римских и арабских цифр";
    public static final String ruleText = "Цифры могут быть либо римские либо арабские. Каждая цифра не должна быть больше 10. \n" +
            "Доступно сложение, вычитание, умножение и деление. Результат всегда челочисленный.";
    public static final String exampleText = "Примеры ввода: 3+5, II+IX";
    public static final String tryText ="Введите выражение или введите q для выхода";
    public static final String byeText ="До свиданья.";

    public static final String ERROR_wrongDigitType = "Неверный тип цифр";
    public static final String ERROR_limits = "Слишком большие числа";
    public static final String ERROR_incorrectExpression = "Неверный формат выражения";

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DEVIDE = "/";
    public static final String EXIT = "q";

    public static final String ARABIC_REGEX = "^[0-9]{1,2}[*-\\/+]{1}[0-9]{1,2}$";
    public static final String ROMAN_REGEX = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})[*-\\/+]{1}(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
}
