package com.mw.java8.c9;

public class Child2 implements InterfaceB, InterfaceC
{
    public static void main(String[] args)
    {
        Child2 c = new Child2();
        System.out.println(c.say());
    }
}
