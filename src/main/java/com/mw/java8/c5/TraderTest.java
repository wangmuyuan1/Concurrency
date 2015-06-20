package com.mw.java8.c5;

import com.mw.java8.c5.entity.Trader;
import com.mw.java8.c5.entity.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TraderTest
{
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario","Milan");
    private static Trader alan = new Trader("Alan","Cambridge");
    private static Trader brian = new Trader("Brian","Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 600),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args)
    {
        findAllTraderFromCambridge();
    }

//    1. Find all transactions in the year 2011 and sort them by value (small to high).
    private static void findAllTransaction()
    {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);
    }

//    2. What are all the unique cities where the traders work?
    private static void findAllTraders()
    {
        System.out.println(transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(joining(", ")));
    }

//    3. Find all traders from Cambridge and sort them by name.
    private static void findAllTraderFromCambridge()
    {
        transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).collect(toList())
        .forEach(System.out::println);
    }

//    4. Return a string of all traders’ names sorted alphabetically.
    private static void findAllTraderName()
    {
        System.out.println(transactions.stream().map(t -> t.getTrader().getFirstName()).sorted().collect(joining(", ")));
    }

//    5. Are any traders based in Milan?
    private static void findAnyInMilan()
    {
        System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
    }

//    6. Print all transactions’ values from the traders living in Cambridge.
    private static void findCambridgeTransaction()
    {
        List<Transaction> transactionList = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).collect(toList());
        transactionList.forEach(System.out::println);
    }

//    7. What’s the highest value of all the transactions?
    private static void findMax()
    {
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).max(Integer::max);
        if (max.isPresent())
        {
            System.out.println(max.get());
        }
    }

//    8. Find the transaction with the smallest value.
    private static void findSmallestValueTransaction()
    {
        Optional<Transaction> t = transactions.stream().sorted(comparing(Transaction::getValue)).findFirst();
        if (t.isPresent())
        {
            System.out.println(t.get());
        }
    }
}
