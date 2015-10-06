package com.mw.leetcode.p1to10;

public class StringtoInteger8
{
    public static int myAtoi(String str)
    {
        if (str == null || str.length() == 0)
        {
            return 0;
        }

        str = str.trim();

        double result = 0;
        for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < str.length(); i++)
        {
            if (result == 0 && str.charAt(i) == 48)
                continue;
            if (str.charAt(i) < 48 || str.charAt(i) > 57)
            {
                break;
            }

            result = result * 10 + (str.charAt(i) - 48);
        }

        if (str.charAt(0) == '-')
        {
            result = result * -1;
        }

        if (result > Integer.MAX_VALUE)
        {
            result = Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE)
        {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String args[])
    {
        System.out.println("13999999");
    }
}
