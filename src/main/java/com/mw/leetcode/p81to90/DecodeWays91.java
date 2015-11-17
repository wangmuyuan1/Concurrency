package com.mw.leetcode.p81to90;

public class DecodeWays91
{
    public static int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++)
        {
            if(isValid(s.substring(i - 1, i)))
                dp[i] += dp[i - 1];

            if(i > 1 && isValid(s.substring(i - 2, i)))
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }

    private static boolean isValid(String s)
    {
        if(s.charAt(0)=='0')
            return false;
        int value = Integer.parseInt(s);
        return value >=1 && value <= 26;
    }

    public static void main(String[] args)
    {
        System.out.println(numDecodings("12120"));
    }
}
