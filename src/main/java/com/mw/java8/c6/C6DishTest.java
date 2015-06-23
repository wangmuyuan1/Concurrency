package com.mw.java8.c6;

import com.mw.java8.c6.entity.C6CaloricLevel;
import com.mw.java8.c6.entity.C6Dish;
import com.mw.java8.c6.entity.C6DishType;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class C6DishTest
{
    private static List<C6Dish> dishes = Arrays.asList(
                    new C6Dish("Carrot", 200, true, C6DishType.OTHER, C6CaloricLevel.DIET),
                    new C6Dish("Cabbage", 250, true, C6DishType.OTHER, C6CaloricLevel.DIET),
                    new C6Dish("Cod", 600, false, C6DishType.FISH, C6CaloricLevel.NORMAL),
                    new C6Dish("Salmon", 500, false, C6DishType.FISH, C6CaloricLevel.NORMAL),
                    new C6Dish("Beef", 850, false, C6DishType.MEAT, C6CaloricLevel.FAT),
                    new C6Dish("Sausage", 850, false, C6DishType.MEAT, C6CaloricLevel.FAT),
                    new C6Dish("Potato", 550, true, C6DishType.OTHER, C6CaloricLevel.NORMAL),
                    new C6Dish("Pork", 800, false, C6DishType.MEAT, C6CaloricLevel.FAT));

    public static void main(String[] args)
    {
        getAllCalInGroup();
    }


    private static void getNumOfDishes()
    {
        System.out.println(dishes.stream().count());
        System.out.println(dishes.stream().max(comparingInt(C6Dish::getCalories)));
        System.out.println(dishes.stream().collect(summarizingInt(C6Dish::getCalories)));

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(new ArrayList<>(),
                (List<Integer> l, Integer e) ->
                {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) ->
                {
                    l1.addAll(l2);
                    return l1;
                });
        numbers.forEach(System.out::println);
    }

    private static void multiLevelGrouping()
    {
        Map<Boolean, Map<C6CaloricLevel, List<C6Dish>>> result = dishes.stream().collect(groupingBy(C6Dish::isVegetarian, groupingBy(C6Dish::getCaloricLevel)));
        result.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    private static void groupByCounting()
    {
        Map<C6CaloricLevel, Long> result = dishes.stream().collect(groupingBy(C6Dish::getCaloricLevel, counting()));
        result.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    private static void maxByGroup()
    {
        dishes.stream().collect(groupingBy(C6Dish::getCaloricLevel, maxBy(comparingInt(C6Dish::getCalories)))).forEach((k, v) -> System.out.println(k + ", " + v));
    }

    private static void totalCalInGroup()
    {
        dishes.stream().collect(groupingBy(C6Dish::getCaloricLevel, summingInt(C6Dish::getCalories))).forEach((k, v) -> System.out.println(k + ", " + v));
    }

    private static void findHighestCalInSubGroup()
    {
        Map<C6DishType, C6Dish> result = dishes.stream().collect(groupingBy(C6Dish::getDishType, collectingAndThen(maxBy(comparingInt(C6Dish::getCalories)), Optional::get)));
    }

    private static void getAllCalInGroup()
    {
        dishes.stream().collect(groupingBy(C6Dish::getDishType, mapping(C6Dish::getCaloricLevel, toCollection(HashSet::new)))).forEach((k, v) -> System.out.println(k + ", " + v));
    }
}
