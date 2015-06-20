package com.mw.java8.c5;

import com.mw.java8.c5.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DishTest
{
    private static List<Dish> dish = createDishList();

    public static void main(String[] args)
    {
        getSumOfCalAllDishes();
    }

    private static void filter()
    {
        List<String> lowCalNames = createDishList().stream()
                .filter(a -> a.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        lowCalNames.forEach(System.out::println);
    }

    private static void truncate()
    {
        List<String> lowCalNameLimit2 = createDishList().stream()
                .filter(a -> a.getCalories() > 300)
                .limit(2)
                .map(Dish::getName)
                .collect(toList());
        lowCalNameLimit2.forEach(System.out::println);
    }

    private static void skip()
    {
        List<String> lowCalNameSkip = createDishList().stream()
                .filter(a -> a.getCalories() > 300)
                .skip(2)
                .map(Dish::getName)
                .collect(toList());
        lowCalNameSkip.forEach(System.out::println);
    }

    private static void joinResult()
    {
        String lowCalNameSkip = createDishList().stream()
                        .filter(a -> a.getCalories() > 300)
                        .skip(2)
                        .map(Dish::getName)
                        .collect(joining(","));
        System.out.println(lowCalNameSkip);
    }

    private static void mapWordSplit()
    {
        List<String> wordList = createDishList().stream()
                        .map(Dish::getName)
                        .collect(toList())
                        .stream()
                        .map(s -> s.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());

        System.out.println(wordList);
    }

    private static void mapNumber()
    {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);

        List<int[]> pairs = numbers1.stream()
                .flatMap(a -> numbers2.stream().map(b -> new int[]{a, b}))
                .collect(toList());

        pairs.forEach(a -> System.out.println(a[0] + "," + a[1]));
    }

    private static void predict()
    {
        System.out.println(createDishList().stream().anyMatch(d -> d.getName().equals("Beef")));
        System.out.println(createDishList().stream().anyMatch(d -> d.getName().equals("Lamb")));

        Optional<Dish> dish = createDishList().stream().filter(Dish::isVegetarian).findFirst();
        System.out.println(dish.get());
    }

    private static void reducing()
    {
        int totalCal = createDishList().stream()
                .mapToInt(Dish::getCalories)
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalCal);

        OptionalInt totalCal1 = createDishList().stream().mapToInt(Dish::getCalories).reduce(Integer::sum);
        System.out.println(totalCal1.getAsInt());
    }

    private static void getSumOfCalAllDishes()
    {
        System.out.println(dish.stream().mapToInt(Dish::getCalories).sum());
    }

    private static void getMaxCalAllDishes()
    {
        OptionalInt maxCal = dish.stream().mapToInt(Dish::getCalories).max();
        System.out.println(maxCal.orElse(1));
    }

    private static List<Dish> createDishList()
    {
        return Arrays.asList(
                new Dish("Carrot", 200, true),
                new Dish("Salmon", 300, false),
                new Dish("Beef", 450, false),
                new Dish("Sausage", 350, false),
                new Dish("Potato", 350, true),
                new Dish("Pork", 500, false));
    }
}
