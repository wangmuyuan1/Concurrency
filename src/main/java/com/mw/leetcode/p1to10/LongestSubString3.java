package com.mw.leetcode.p1to10;

public class LongestSubString3
{
    public static int lengthOfLongestSubstring(String s)
    {
        int[] value = new int[256];
        int start = 0;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (value[c] > 0)
            {
                max = Math.max(max, cur);
                if (value[c] >= start)
                {
                    start = value[c];
                    cur = i - value[c] + 1;
                }
                else
                {
                    value[c] = i + 1;
                    cur++;
                }
            }
            else
            {
                cur++;
            }
            value[c] = i + 1;
        }
        return Math.max(max, cur);
    }

    public static void main(String[] args)
    {
        //"abcabcbb" is "abc"
        //"bbbbb" is b

        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
