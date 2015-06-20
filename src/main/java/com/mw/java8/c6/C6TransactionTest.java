package com.mw.java8.c6;

import com.mw.java8.c6.entity.C6Trader;
import com.mw.java8.c6.entity.C6Transaction;
import com.mw.java8.c6.entity.C6Currency;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class C6TransactionTest
{
    private static C6Trader raoul = new C6Trader("Raoul", "Cambridge");
    private static C6Trader mario = new C6Trader("Mario","Milan");
    private static C6Trader alan = new C6Trader("Alan","Cambridge");
    private static C6Trader brian = new C6Trader("Brian","Cambridge");

    private static List<C6Transaction> transactions = Arrays.asList(
            new C6Transaction(brian, 2011, 600, C6Currency.DOLLAR),
            new C6Transaction(raoul, 2012, 1000, C6Currency.EURO),
            new C6Transaction(raoul, 2011, 400, C6Currency.EURO),
            new C6Transaction(mario, 2012, 710, C6Currency.STERLING),
            new C6Transaction(mario, 2012, 700, C6Currency.DOLLAR),
            new C6Transaction(alan, 2012, 950, C6Currency.DOLLAR));

    public static void main(String[] args)
    {
        groupTransactionByCurrency();
    }

    public static void groupTransactionByCurrency()
    {
        Map<C6Currency, List<C6Transaction>> result = transactions.stream().collect(groupingBy(C6Transaction::getCurrency));
        result.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
    }
}
