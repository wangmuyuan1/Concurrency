package com.mw.leetcode.p181to190;

public class Numberof1Bits191
{
    public int hammingWeight(int n)
    {
        int result = 0;
        while (n != 0)
        {
            if ((n & 1) == 1)
            {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new Numberof1Bits191().hammingWeight(3));
    }
}
