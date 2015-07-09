package com.mw.java8.c11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class Shop
{
    private String name;

    public Shop(String name)
    {
        this.name = name;
    }

    public Future<Double> getPriceAsync(String product)
    {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try
            {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }
            catch (Exception ex)
            {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncV2()
    {
        return CompletableFuture.supplyAsync(() -> calculatePrice(this.name));
    }

    public Double getPrice()
    {
        try
        {
            return this.getPriceAsyncV2().get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();  //TODO - remove
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();  //TODO - remove
        }
        return new Double(0);
    }

    private double calculatePrice(String product)
    {
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return product.hashCode();
    }

    public String getName()
    {
        return name;
    }

    public static void main(String[] args)
    {
        /*
        Shop shop = new Shop();
        long start = System.nanoTime();
        System.out.println("Looking for price.");
        Future<Double> doubleFuture = shop.getPriceAsync("Apple");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Job submitted in " + duration + "ms.");
        System.out.println("I am shopping something else.");
        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Shopping done.");
        try
        {
            doubleFuture.get();
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("retrieve the price in " + duration + "ms.");
        */

        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        List<String> prices = shops.parallelStream().map(s -> s.getName() + " price:" + s.getPrice()).collect(toList());
        prices.forEach(System.out::println);
    }
}
