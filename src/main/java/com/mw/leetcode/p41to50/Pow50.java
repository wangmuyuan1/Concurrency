package com.mw.leetcode.p41to50;

public class Pow50
{
    public static double myPow(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }

        if (n < 0)
        {
            x = 1 /x;
            n = -n;
        }

        if (Math.abs(n) == 1)
        {
            return x;
        }

        if (n % 2 == 1)
        {
            return x * myPow(x * x, n / 2);
        }
        else
        {
            return myPow(x * x, n / 2);
        }
    }

    public static void main(String args[])
    {
        System.out.println(myPow(-2, 0));
    }
}
