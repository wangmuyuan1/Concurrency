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
            dp[i][0] = true; // a char itself is palindrome.
        }

        for (int i = 0; i < s.length() - 1; i++)
        {
            dp[i][1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int j = 2; j < s.length(); j++) //优先计算step
        {
            for (int i = s.length() - j - 1; i >= 0; i--)
            {
                dp[i][j] = (s.charAt(i) == s.charAt(i + j)) && dp[i + 1][j - 2]; // here has to be j - 2, as both end.
            }
        }

        // Check the longest. because j
        int start = 0;
        int length = 0;
        for (int j = 0; j < s.length(); j++)
        {
            for (int i = 0; i < s.length() - j; i++)
            {
                if (dp[i][j] && j > length)
                {
                    start = i;
                    length = j;
                }
            }
        }

        return s.substring(start, start + length + 1);
    }

    public static void main(String[] args)
    {
        //System.out.println(longestPalindrome("acc"));
        System.out.println(longestPalindrome("cuyabbaydd"));
    }
}
