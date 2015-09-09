package com.mw.leetcode.p1to10;

public class ReverseInteger7
{
    public static int reverse(int x)
    {
        int result = 0;
        int lastDigit = 0;

        while (x != 0)
        {
            lastDigit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
            {
                return 0;
            }
            result = result * 10 + lastDigit;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args)
    {
        //Example1: x = 123, return 321
        //Example2: x = -123, return -321
        System.out.println(reverse(-2147483412));
    }
}
