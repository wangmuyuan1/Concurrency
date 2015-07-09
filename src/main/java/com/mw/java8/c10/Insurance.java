package com.mw.java8.c10;

public class Insurance
{
    private Person person;
    private Car car;
    private String name;

    public Insurance(Person person, Car car, String name)
    {
        this.person = person;
        this.car = car;
        this.name = name;
    }

    public Person getPerson()
    {
        return person;
    }

    public Car getCar()
    {
        return car;
    }

    public String getName()
    {
        return name;
    }
}
