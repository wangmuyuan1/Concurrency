package com.mw.java8.c6.entity;

public class C6Transaction
{
    private C6Trader trader;
    private int year;
    private int value;
    private C6Currency currency;

    public C6Transaction(C6Trader trader, int year, int value, C6Currency currency)
    {
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = currency;
    }

    public C6Trader getTrader()
    {
        return trader;
    }

    public int getYear()
    {
        return year;
    }

    public int getValue()
    {
        return value;
    }

    public C6Currency getCurrency()
    {
        return currency;
    }

    public boolean isDollar()
    {
        return this.currency == C6Currency.DOLLAR;
    }

    @Override
    public String toString()
    {
        return "C6Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                ", currency=" + currency +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        C6Transaction that = (C6Transaction) o;

        if (value != that.value)
        {
            return false;
        }
        if (year != that.year)
        {
            return false;
        }
        if (currency != that.currency)
        {
            return false;
        }
        if (trader != null ? !trader.equals(that.trader) : that.trader != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = trader != null ? trader.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + value;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }


}