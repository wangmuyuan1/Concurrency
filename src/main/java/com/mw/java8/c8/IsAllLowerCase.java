package com.mw.java8.c8;

public class IsAllLowerCase implements ValidationStrategy
{
    @Override
    public boolean execute(String s)
    {
        return s.matches("[a-z]+");
    }
}
