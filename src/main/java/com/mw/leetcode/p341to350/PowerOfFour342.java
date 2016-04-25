package com.mw.leetcode.p341to350;

/**
 * Created by mwang on 24/04/2016.
 */
public class PowerOfFour342
{
    public boolean isPowerOfFour(int num)
    {

        if (num == 1 || num == 4) return true;
        int temp = 4;
        for (int i = 0; i < 14; i++)
        {
            if (num == temp << 2)
                return true;
            temp <<= 2;
        }
        return false;
    }

    public static void main(String[] args)
    {
        PowerOfFour342 app = new PowerOfFour342();
        System.out.println(app.isPowerOfFour(-2147483648));
        System.out.println(app.isPowerOfFour(8));
        System.out.println(app.isPowerOfFour(16));
        System.out.println(app.isPowerOfFour(4));
        System.out.println(app.isPowerOfFour(1));
    }
}
