package com.mw.leetcode.p61to70;

public class Sqrt69
{
    public static int mySqrt(int x)
    {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;
        if (x == 1)
            return x;
        long target = x;
        long left = 1;
        long right = target / 2;
        while (left < right)
        {
            long mid = (left + right) / 2;
            if (mid * mid > x)
            {
                right = mid - 1;
            }
            else if (mid * mid < x)
            {
                left = mid + 1;
            }
            else
            {
                return (int) mid;
            }
        }
        if (left * left > target)
            return (int) left - 1;
        else
            return (int) left;
    }

    public static void main(String[] args)
    {
        System.out.println(mySqrt(4));
    }
}
