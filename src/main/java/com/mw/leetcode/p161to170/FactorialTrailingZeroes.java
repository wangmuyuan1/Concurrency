package com.mw.leetcode.p161to170;

public class FactorialTrailingZeroes
{
    public int trailingZeroes(int n)
    {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args)
    {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(150));
    }
}
