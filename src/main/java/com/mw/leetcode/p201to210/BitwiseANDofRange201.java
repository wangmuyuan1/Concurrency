package com.mw.leetcode.p201to210;

public class BitwiseANDofRange201
{
    public int rangeBitwiseAnd(int m, int n)
    {
        // move m and n to right and once they match, then that result contains common 1s.
        int count = 0;
        while (m != n)
        {
            m >>= 1;
            n >>= 1;
            count++;
        }

        return m << count;
    }

    public static void main(String[] args)
    {
        System.out.println(new BitwiseANDofRange201().rangeBitwiseAnd(5, 7));
    }
}
