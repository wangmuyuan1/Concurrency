package com.mw.java8.entity;

public class Dish
{
    private String name;
    private int calories;
    private boolean isVegetarian;

    public Dish(String name, int calories, boolean isVegetarian)
    {
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
    }

    public String getName()
    {
        return name;
    }

    public int getCalories()
    {
        return calories;
    }

    public boolean isVegetarian()
    {
        return isVegetarian;
    }

    @Override
    public String toString()
    {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                '}';
    }
}
