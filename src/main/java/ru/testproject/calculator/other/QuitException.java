package ru.testproject.calculator.other;

public class QuitException extends Exception {
    public String toString() {
        return Constants.byeText;
    }
}
