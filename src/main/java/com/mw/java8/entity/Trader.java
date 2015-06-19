package com.mw.java8.entity;

public class Trader
{
    private String firstName;
    private String city;

    public Trader(String firstName, String city)
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

        Trader trader = (Trader) o;

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
