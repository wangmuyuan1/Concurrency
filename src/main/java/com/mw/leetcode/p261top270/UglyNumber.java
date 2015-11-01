package com.mw.leetcode.p261top270;

public class UglyNumber
{
    public static boolean isUgly(int num)
    {
        while (num > 2 && num != 3 && num != 5)
        {
            if (num % 2 == 0)
            {
                num /= 2;
            }
            else if (num % 3 == 0)
            {
                num /= 3;
            }
            else if (num % 5 == 0)
            {
                num /= 5;
            }
            else
            {
                break;
            }
        }
        return num == 2 || num == 3 || num == 5 || num == 1;
    }

    public static void main(String[] args)
    {
        System.out.println(isUgly(1));
    }
}
