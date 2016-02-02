package com.mw.leetcode.p21top30;

public class DivideTwoIntegers29
{
    public int divide(int dividend, int divisor)
    {
        // idea.
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        int result = 0;
        long tempDividend = Math.abs((long) dividend);
        long tempDivisor = Math.abs((long) divisor);

        if (tempDividend == 0 || tempDivisor == 0 || tempDividend < tempDivisor) return 0;

        while (tempDividend >= tempDivisor)
        {
            int shift = 0;
            while (tempDividend >= (tempDivisor << shift)) shift++;

            result = result + (1 << (shift - 1));
            tempDividend = tempDividend - (tempDivisor << (shift - 1));
        }
        return (dividend * divisor > 0) ? result : -result;
    }

    public static int divide1(int dividend, int divisor)
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

            while (tempDividend >= (tempDivisor << shift)) // find last shift that dividend < shifted value. like try 2, 4, 8 times.
                shift++; // A number shift once means * 2, eg. 00000011 (3) -> 00000110 (6) -> 00001100 (12)

            result = result + (1 << (shift - 1)); // if we shifted twice then four times.
            tempDividend = tempDividend - (tempDivisor << (shift - 1));
        }

        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? result : -result;
    }

    public static void main(String[] args)
    {
        System.out.println(new DivideTwoIntegers29().divide(-12, 2));
    }
}
