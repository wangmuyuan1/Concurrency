package com.mw.leetcode.p11to20;

import java.util.HashMap;

public class RomanToInteger13
{
    public static int romanToInt(String s)
    {
        // read two char every time to determine it scale.
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);

        char cur;
        char next;
        int val = 0;
        for (int i = 0; i < s.length(); i++)
        {
            cur = s.charAt(i);
            if (i + 1 < s.length())
            {
                next = s.charAt(i + 1);
                if (values.get(cur) < values.get(next))
                {
                    val += values.get(next) - values.get(cur);
                    i++;
                }
                else
                {
                    val += values.get(cur);
                }
            }
            else
            {
                val += values.get(cur);
            }
        }

        return val;
    }

    public static void main(String[] args)
    {
        System.out.println(romanToInt("CDXCIX"));
    }
}
