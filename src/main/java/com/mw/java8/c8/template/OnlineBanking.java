package com.mw.java8.c8.template;

import java.util.function.Consumer;

class OnlineBanking
{
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy)
    {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    public static void main(String[] args)
    {
        new OnlineBanking().processCustomer(26, (c) -> System.out.println(c.getId() + " is happy."));
    }
}