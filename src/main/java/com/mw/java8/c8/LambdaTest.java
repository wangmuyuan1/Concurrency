package com.mw.java8.c8;

public class LambdaTest
{
    public static void main(String[] args)
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {

            }
        };

        Runnable r2 = () -> System.out.println();

        int a = 2;

        // this and super inside Lambda expression refers to enclosing class.
        /*
        Runnable r3 = () -> {
            int a = 3;
            System.out.println(a);
        };*/
    }
}
