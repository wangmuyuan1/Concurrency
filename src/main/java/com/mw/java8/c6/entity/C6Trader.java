package com.mw.java8.c6.entity;

public class C6Trader
{
    private String firstName;
    private String city;

    public C6Trader(String firstName, String city)
    {
        this.firstName = firstName;
        this.city = city;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getCity()
    {
        return city;
    }

    @Override
    public String toString()
    {
        return "Trader{" +
                "firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
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

        C6Trader trader = (C6Trader) o;

        if (firstName != null ? !firstName.equals(trader.firstName) : trader.firstName != null)
        {
            return false;
        }
        if (city != null ? !city.equals(trader.city) : trader.city != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
