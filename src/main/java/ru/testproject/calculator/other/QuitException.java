package ru.testproject.calculator.other;

/**
 * Исключение для выхода из программы
 */
public class QuitException extends Exception {
    public String toString() {
        return Constants.byeText;
    }
}
