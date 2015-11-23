package com.mw.leetcode.p131to140;

public class PalindromePartitioningII132
{
    /**
     * 思路：这道题和max palindrome类似，用dp解可以判定是否为palindrome,然后不为palindrome的字符各占1个cut.
     */
    public int minCut(String s)
    {
        if (s.length() <= 1)
            return 0;

        // 这个矩阵保存了从i开始，extend到J，这个子串是否是palindrome.
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length() + 1];

        for (int i = 0; i <= s.length();i++)
            cut[i] = i;

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j >= 0; j--)
            {
                if ((s.charAt(i) == s.charAt(j)) && (i - j <= 1 || dp[j + 1][i - 1]))
                {
                    dp[j][i] = true;
                    cut[i + 1] = Math.min(cut[j] + 1, cut[i + 1]);
                }
            }
        }
        return cut[s.length()] - 1;
    }

    public static void main(String[] args)
    {
        PalindromePartitioningII132 app = new PalindromePartitioningII132();
        //System.out.println(app.minCut("abc"));
        System.out.println(app.minCut("cuyabbaydd"));
    }
}