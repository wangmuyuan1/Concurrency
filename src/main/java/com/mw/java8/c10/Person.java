package com.mw.java8.c10;

import java.util.Optional;

public class Person
{
    private Optional<Car> car;

    public Optional<Car> getCar()
    {
        return car;
    }

    public void setCar(Optional<Car> car)
    {
        this.car = car;
    }
}
