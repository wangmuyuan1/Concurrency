package com.mw.leetcode.p271to280;

import java.util.Arrays;

/**
 * Created by mwang on 04/05/2016.
 */
public class PerfectSquares279
{
    public int numSquares(int n)
    {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
        {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i >= j * j)
            {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        PerfectSquares279 app = new PerfectSquares279();
        System.out.println(app.numSquares(10));
    }
}
