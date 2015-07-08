package com.mw.java8.c8.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingObject
{
    public static void main(String[] args)
    {
        UnaryOperator<String> headerProcessing = (text) -> "From Paul, Mario and John: " + text;
        UnaryOperator<String> textProcessing = (text) -> text.replaceAll("Halo", "Hello");

        Function<String, String> pipeline = headerProcessing.andThen(textProcessing);
        System.out.println(pipeline.apply("Halo Moto!"));
    }
}
