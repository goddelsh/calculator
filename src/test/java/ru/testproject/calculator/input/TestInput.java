package ru.testproject.calculator.input;

public class TestInput implements Input {
    private String input;

    public TestInput(String input){
        this.input = input;
    }

    @Override
    public String askExpression(String question) {
        System.out.println(question);

        return this.input;
    }
}

