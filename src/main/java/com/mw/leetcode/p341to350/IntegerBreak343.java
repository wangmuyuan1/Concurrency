package com.mw.leetcode.p341to350;

/**
 * Created by mwang on 27/04/2016.
 */
public class IntegerBreak343
{
    public int integerBreak(int n)
    {
        if (n == 3)
            return 2;
        if (n == 2)
            return 1;
        if (n == 1)
            return 0;
        return intBreak(n);
    }

    private int intBreak(int n)
    {
        if (n == 3)
            return 3;
        if (n == 2)
            return 2;
        if (n == 1)
            return 0;
        return Math.max(intBreak(n - 2) * 2, intBreak(n - 3) * 3);
    }

    public static void main(String[] args)
    {
        IntegerBreak343 app = new IntegerBreak343();
        System.out.println(app.integerBreak(1));
        System.out.println(app.integerBreak(2));
        System.out.println(app.integerBreak(3));
        System.out.println(app.integerBreak(6));
    }
}
