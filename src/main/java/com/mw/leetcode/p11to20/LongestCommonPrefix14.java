package com.mw.leetcode.p11to20;

public class LongestCommonPrefix14
{
    public String longestCommonPrefix(String[] strs)
    {
        String result = "";

        if (strs.length == 0)
            return result;

        for (int i = 0; ; i++)
        {
            if (strs[0].length() == i)
            {
                return result;
            }

            for (int k = 0; k < strs.length; k++)
            {
                if (i == strs[k].length())
                {
                    return strs[k];
                }

                if (strs[k].charAt(i) != strs[0].charAt(i))
                {
                    return result;
                }
            }

            result += strs[0].charAt(i);
        }
    }

    public static void main(String[] args)
    {

    }
}
