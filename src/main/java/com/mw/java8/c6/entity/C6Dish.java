package com.mw.java8.c6.entity;

public class C6Dish
{
    private String name;
    private int calories;
    private boolean isVegetarian;
    private C6CaloricLevel caloricLevel;

    public C6Dish(String name, int calories, boolean isVegetarian, C6CaloricLevel caloricLevel)
    {
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.caloricLevel = caloricLevel;
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

    public C6CaloricLevel getCaloricLevel()
    {
        return caloricLevel;
    }

    @Override
    public String toString()
    {
        return "C6Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                ", caloricLevel=" + caloricLevel +
                '}';
    }
}
