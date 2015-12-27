package com.mw.leetcode.p211to220;

public class ShortestPalindrome214
{
    public static String shortestPalindrome(String s)
    {
        String rev = new StringBuilder(s).reverse().toString();
        String str = s + '#' + rev;
        int[] dp = new int[str.length()];

        // if s = abab then str = abda#adba
        // then dp should be 00
        // the definition of dp and j dp = the next position of matching to match.
        // The #{is to make it to stop}
        // then we know the position to cut in rev string.
        for (int i = 1 ; i < str.length(); i++)
        {
            int j = dp[i - 1];
            while (j > 0 && str.charAt(j) != str.charAt(i))
            {
                j = dp[j - 1];
            }
            dp[i] = j += (str.charAt(i) == str.charAt(j) ? 1 : 0);
        }

        return rev.substring(0, rev.length() - dp[str.length() - 1]) + s;
    }

    public static void main(String[] args)
    {
        System.out.println(ShortestPalindrome214.shortestPalindrome("abda"));
    }
}
