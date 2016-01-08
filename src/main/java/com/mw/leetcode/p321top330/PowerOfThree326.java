package com.mw.leetcode.p321top330;

public class PowerOfThree326
{
    public boolean isPowerOfThree(int n)
    {
        return n > 0 && Math.pow(2, ((int)(Math.log(Integer.MAX_VALUE)/Math.log(2)))) % n == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(new PowerOfThree326().isPowerOfThree(18));
    }
}
