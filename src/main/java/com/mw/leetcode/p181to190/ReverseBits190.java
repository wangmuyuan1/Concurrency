package com.mw.leetcode.p181to190;

public class ReverseBits190
{
    public int reverseBits(int n)
    {
        int count = 32;
        int result = 0;
        while (count > 0)
        {
            int mask = n & 1;
            result = result | mask;
            n >>>= 1;
            if (count > 1)
                result <<= 1;
            count --;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(new ReverseBits190().reverseBits(43261596)));
    }
}
