package com.mw.java8.c6.entity;

public class C6Apple
{
    private int id;
    private int weight;

    public C6Apple(int id)
    {
        this.id = id;
    }

    public C6Apple(int index, int weight)
    {
        this.id = id;
        this.weight = weight;
    }

    public String toString()
    {
        return "Apple [id:" + id + "][Weight:" + weight + "]";
    }
}
