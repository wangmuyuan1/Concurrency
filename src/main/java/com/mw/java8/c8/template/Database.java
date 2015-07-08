package com.mw.java8.c8.template;

public class Database
{
    public static Customer getCustomerWithId(int id)
    {
        return new Customer(id);
    }
}
