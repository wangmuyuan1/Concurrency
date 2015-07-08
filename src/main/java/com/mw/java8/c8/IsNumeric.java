package com.mw.java8.c8;

import com.mw.java8.c8.strategy.ValidationStrategy;

public class IsNumeric implements ValidationStrategy
{
    @Override
    public boolean execute(String s)
    {
        return s.matches("\\d+");
    }
}
