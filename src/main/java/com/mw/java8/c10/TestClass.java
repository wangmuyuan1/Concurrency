package com.mw.java8.c10;

import java.util.Optional;

public class TestClass
{
    public static void main(String[] args)
    {
        Person person1 = new Person();

        Optional<Car> car = Optional.empty();
        person1.setCar(car);
        System.out.println(person1.getCar().isPresent());

        car = Optional.ofNullable(null);
        person1.setCar(car);
        System.out.println(person1.getCar().isPresent());

        car = Optional.ofNullable(new Car());
        person1.setCar(car);
        System.out.println(person1.getCar().isPresent());

        car = Optional.of(null);
    }
}
