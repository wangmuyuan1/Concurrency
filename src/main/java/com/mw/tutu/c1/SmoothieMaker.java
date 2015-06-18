package com.mw.tutu.c1;

public class SmoothieMaker
{
    private Apple apple;

    public boolean add(Apple apple)
    {
        if (apple.getWeight() > 10)
        {
            this.apple = apple;
            return true;
        }
        else
        {
            return false;
        }
    }
}
