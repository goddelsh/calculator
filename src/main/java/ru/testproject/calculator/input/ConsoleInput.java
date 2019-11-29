package ru.testproject.calculator.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scaner = new Scanner(System.in);

    public String askExpression(String question) {
        System.out.println(question);
        return scaner.nextLine();
    }
}
