package com.mw.java8.c8.observer;

import java.util.HashSet;
import java.util.Set;

public class Feed
{
    private Set<Observer> observers = new HashSet<>();

    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void accept(String tweet)
    {
        observers.stream().forEach((o) -> o.notify(tweet));
    }

    public static void main(String[] args)
    {
        Feed feed = new Feed();
        feed.registerObserver((tweet) -> {
            if (tweet.contains("Dublin"))
            {
                System.out.println("Breaking news in Dublin !!!");
            }
        });
        feed.registerObserver((tweet) -> {
            if (tweet.contains("Traffic"))
            {
                System.out.println("Latest Traffic update.");
            }
        });

        feed.accept("New York");
        feed.accept("Dublin");
        feed.accept("Traffic");
    }
}
