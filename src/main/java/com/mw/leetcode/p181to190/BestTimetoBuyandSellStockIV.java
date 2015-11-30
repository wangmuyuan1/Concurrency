package com.mw.leetcode.p181to190;

public class BestTimetoBuyandSellStockIV
{
    public int maxProfit(int k, int[] prices)
    {
        //动态规划，对于price[0, n], 定义dp[i, j]为i次transaction，j为当前price的长度。
        //对于dp[i,j] 它至少为dp[i-1,j]和dp[i,j-1]当长度少一的时候的较大值 + 当前的profit（）
        //如何计算profit是很有意思的一件事情，首先我们要知道除去买
        int len = prices.length;
        if (k >= len/2)
            return quickSolve(k, prices);

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++)
        {
            //我们需要个tmpMaxProfit一个初值
            int tmpMaxProfit = -prices[0]; //你必须假设我们如果买入price[0]，这时候是没有profit的
            for (int j = 1; j < len; j++) //我们不需要计算0位置
            {
                //首先我们需要计算当前的dp的值，也就是当前的最大profit
                //因为tmpMaxProfit是由前一个值计算而来的，也就意味着这里用来比较，如果我们向后移了一位，并且在j这个位置卖出了股票是不是比在j-1的时候要高。
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMaxProfit);
                tmpMaxProfit = Math.max(tmpMaxProfit, dp[i - 1][j - 1] - prices[j]);
            }
        }

        return dp[k][len - 1];
    }

    private int quickSolve(int k, int[] prices)
    {
        int max = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        return max;
    }
}
