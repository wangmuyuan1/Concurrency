package com.mw.leetcode.p261top270;

public class UglyNumberII264
{
    public int nthUglyNumber(int n)
    {
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0; int three = 0; int five = 0;
        for (int i = 1; i < n; i++)
        {
            dp[i] = Math.min(Math.min(dp[two] * 2, dp[three] * 3), dp[five] * 5);
            if (dp[i] == dp[two] * 2) two++;
            if (dp[i] == dp[three] * 3) three++;
            if (dp[i] == dp[five] * 5) five++;
        }
        // dp[0] = 1, dp[1] = 2, dp[2] = 3, dp[3] = 4, dp[4] = 5, dp[5] = 6;
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        UglyNumberII264 app = new UglyNumberII264();
        System.out.println(app.nthUglyNumber(10));
    }
}
