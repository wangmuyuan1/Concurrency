package com.mw.leetcode.p201to210;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202
{
    public boolean isHappy(int n)
    {
        // How to determine it is in cycle? HashSet.
        Set<Integer> result = new HashSet<>();
        do
        {
            n = calc(n);
            if (!result.add(n)) // in loop, return false.
                return false;
        }
        while (n != 1);

        return true;
    }

    private int calc(int n)
    {
        int res = 0;
        while (n > 0)
        {
            int digit = n % 10;
            res = res + digit * digit;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(new HappyNumber202().isHappy(11));
    }
}
