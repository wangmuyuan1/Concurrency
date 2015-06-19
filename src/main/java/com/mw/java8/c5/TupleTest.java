package com.mw.java8.c5;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TupleTest
{
    public static void main(String[] args)
    {
        generateTuples();
    }

    private static void generateTuples()
    {
        List<int[]> results =  IntStream.rangeClosed(1, 10).boxed()
                .flatMap(a -> IntStream
                        .rangeClosed(1, 10)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})).collect(toList());

        results.forEach(a -> System.out.println(a[0] + ", " + a[1] + ", " + a[2]));
    }
}
