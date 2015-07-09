package com.mw.java8.c9;

public class Child extends ClassB implements InterfaceA
{
    public static void main(String[] args)
    {
        Child c = new Child();
        System.out.println(c.say());
    }
}
