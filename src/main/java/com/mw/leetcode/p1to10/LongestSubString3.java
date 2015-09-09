package com.mw.leetcode.p1to10;

public class LongestSubString3
{
    public static int lengthOfLongestSubstring(String s)
    {
        int[] value = new int[256];
        char[] array = s.toCharArray();

        int start = 0;
        int length = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (value[array[i]] > 0)
            {
                if (length > max)
                {
                    max = length;
                }
                if (value[array[i]] >= start)
                {
                    start = value[array[i]];
                    length = i - value[array[i]] + 1;
                }
                else
                {
                    value[array[i]] = 0;
                    length++;
                }
            }
            else
            {
                length++;
            }
            value[array[i]] = i + 1;
        }

        if (max < length)
        {
            max = length;
        }
        return max;
    }

    public static void main(String[] args)
    {
        //"abcabcbb" is "abc"
        //"bbbbb" is b

        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
