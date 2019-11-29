package ru.testproject.calculator.input;

import ru.testproject.calculator.other.QuitException;

public interface Input {
    /**
     * Интерфейс ввода данных
     * @param question текст печатающийся перед вводом
     * @return обработанный ввод
     * @throws QuitException исключения для выхода из программы
     */
    String askExpression(String question) throws QuitException;
}
