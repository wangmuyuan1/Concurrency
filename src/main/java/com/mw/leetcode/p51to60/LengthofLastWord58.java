package com.mw.leetcode.p51to60;

public class LengthofLastWord58
{
    public static int lengthOfLastWord(String s)
    {
        int length = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                if (cur > 0)
                    length = cur;
                cur = 0;
            }
            else
            {
                cur++;
            }
        }
        if (cur > 0)
            length = cur;
        return length;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLastWord("a"));
    }
}
