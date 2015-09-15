package com.mw.leetcode.p11to20;

public class IntegerToRoman12
{
    public static String intToRoman(int num)
    {
        String result = "";

        // Determine the thousand.
        for (int i = 0; i < num / 1000; i++)
        {
            result += "M";
        }
        num = num % 1000;

        // Determine the 900.
        if (num >= 900)
        {
            result += "CM";
            num = num - 900;
        }
        else if (num >= 500) // determine 500
        {
            result += "D";
            num = num - 500;
        }
        else if (num >= 400) // determine 400
        {
            result += "CD";
            num = num - 400;
        }

        for (int i = 0; i < num / 100; i++)
        {
            result += "C";
        }
        num = num % 100;

        // Determine the 900.
        if (num >= 90)
        {
            result += "XC";
            num = num - 90;
        }
        else if (num >= 50) // determine 500
        {
            result += "L";
            num = num - 50;
        }
        else if (num >= 40) // determine 400
        {
            result += "XL";
            num = num - 40;
        }

        for (int i = 0; i < num / 10; i++)
        {
            result += "X";
        }

        num = num % 10;

        // Determine the 900.
        if (num >= 9)
        {
            result += "IX";
            num = num - 9;
        }
        else if (num >= 5) // determine 500
        {
            result += "V";
            num = num - 5;
        }
        else if (num >= 4) // determine 400
        {
            result += "IV";
            num = num - 4;
        }

        for (int i = 0; i < num; i++)
        {
            result += "I";
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(intToRoman(3997));
    }
}
