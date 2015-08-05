package com.mw.java8.c12;

import java.time.*;

public class LocalDateAndTimeTest
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek len = date.getDayOfWeek();
        boolean leap = date.isLeapYear();

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(month);

        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.atDate(LocalDate.now()));
    }
}
