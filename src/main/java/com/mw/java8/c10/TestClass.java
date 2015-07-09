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
        Car realCar = car.orElseGet(Car::new);
        System.out.println(person1.getCar().isPresent());
        System.out.println(realCar != null);

        car = Optional.ofNullable(new Car());
        person1.setCar(car);
        Insurance insurance = new Insurance(person1, car.get(), "Insurance 1");
        System.out.println(person1.getCar().isPresent());

        // Map Optional Field
        car.get().setInsurance(Optional.ofNullable(insurance));
        Optional<Person> optionalPerson = car.map((c) -> c.getInsurance().get().getPerson());
        System.out.println(optionalPerson.isPresent());

        System.out.println(getCarInsuranceName(Optional.of(person1)));
        Optional<Insurance> optInsurance = Optional.of(insurance);
        optInsurance.filter(i ->
                            "CambridgeInsurance".equals(i.getName()))
                    .ifPresent(x -> System.out.println("ok"));

        //car = Optional.of(null);
    }

    public static String getCarInsuranceName(Optional<Person> person)
    {
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("");
    }
}
