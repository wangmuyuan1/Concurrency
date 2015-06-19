package com.mw.java8.c5;

import com.mw.java8.entity.Apple;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ComparatorTest
{
    public static void main(String[] args)
    {
        //testBasicConstructor();
        testTwoVariableConstructor();
    }

    private static void testBasicConstructor()
    {
        List<Apple> appleList = IntStream.rangeClosed(1, 10).mapToObj(Apple::new).collect(toList());
        appleList.iterator().forEachRemaining(System.out::println);
    }

    private static void testTwoVariableConstructor()
    {
        Random random = new Random();
        List<Apple> appleList = IntStream.rangeClosed(1, 10).mapToObj((a) -> new Apple(a, random.nextInt(10))).collect(toList());
        appleList.iterator().forEachRemaining(System.out::println);
    }
}
