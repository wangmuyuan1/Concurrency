package com.mw.leetcode.p21top30;

public class DivideTwoIntegers29
{
    public static int divide(int dividend, int divisor)
    {
        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        int result = 0;
        long tempDividend = Math.abs((long)dividend);
        long tempDivisor = Math.abs((long)divisor);

        if (tempDividend == 0 || tempDivisor == 0 || tempDividend < tempDivisor)
            return 0;

        // To improve the speed, we can use left shift.

        while (tempDividend >= tempDivisor)
        {
            int shift = 0;

            while (tempDividend >= (tempDivisor << shift)) // Shift but not assign
            {
                shift++;
            }

            result = result + (1 << (shift - 1));
            tempDividend = tempDividend - (tempDivisor << (shift - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
        {
            return result;
        }
        else
        {
            return -result;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(divide(-12, 2));
    }
}
