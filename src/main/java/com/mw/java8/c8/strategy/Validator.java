package com.mw.java8.c8.strategy;

public class Validator
{
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy)
    {
        this.strategy = strategy;
    }

    public boolean validate(String s)
    {
        return strategy.execute(s);
    }

    public static void main(String[] args)
    {
        Validator numericValidator = new Validator((s) -> s.matches("\\d+"));
        System.out.println(numericValidator.validate("aaa"));

        Validator lowerCaseValidator = new Validator((s) -> s.matches("[a-z]+"));
        System.out.println(lowerCaseValidator.validate("aaa"));
    }
}
