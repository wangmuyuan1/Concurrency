package com.mw.leetcode.p90top100;

public class InterleavingString97
{
    public static boolean isInterleave(String s1, String s2, String s3)
    {
        if (s3.length() != s1.length() + s2.length())
            return false;

        if (s1.length() == 0)
            return s3.equals(s2);
        if (s2.length() == 0)
            return s3.equals(s1);

        // why need plus 1, dp[1][1] means dp[0][0] true and s1.charAt(0) == s3.charAt(1) which means s2.charAt(0) has been filled.
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);

        for (int j = 1; j <= s2.length(); j++)
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);

        for (int i = 1; i <= s1.length(); i++)
            for (int j = 1; j <= s2.length(); j++)
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args)
    {
        System.out.println(isInterleave("aa", "ab", "aaba"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
