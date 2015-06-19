package com.mw.java8.entity;

public class Apple
{
    private int id;
    private int weight;

    public Apple(int id)
    {
        this.id = id;
    }

    public Apple(int index, int weight)
    {
        this.id = id;
        this.weight = weight;
    }

    public String toString()
    {
        return "Apple [id:" + id + "][Weight:" + weight + "]";
    }
}
