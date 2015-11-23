package com.mw.leetcode.p1to10;

public class LongestPalindrome5
{
    public static String longestPalindrome(String s)
    {
        if (s.length() <= 1)
            return s;

        // 这个矩阵保存了从i开始，extend到J，这个子串是否是palindrome.
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j >= 0; j--)
            {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j <= 1 || dp[j + 1][i - 1]);
            }
        }

        // Check the longest. because j
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < s.length(); j++)
            {
                if (dp[i][j] && j - i > max)
                {
                    start = i;
                    end = j;
                    max = j - i;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("acc"));
//        System.out.println(longestPalindrome("cuyabbaydd"));
    }
}
