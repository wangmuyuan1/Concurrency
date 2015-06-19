package com.mw.java8.entity;

public class Transaction
{
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value)
    {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader()
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

        Transaction that = (Transaction) o;

        if (value != that.value)
        {
            return false;
        }
        if (year != that.year)
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
        return result;
    }

    @Override
    public String toString()
    {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}