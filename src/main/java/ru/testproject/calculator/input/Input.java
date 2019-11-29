package ru.testproject.calculator.input;

import ru.testproject.calculator.other.QuitException;

public interface Input {
    String askExpression(String question) throws QuitException;
}
