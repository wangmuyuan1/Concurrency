package com.mw.leetcode.p121to130;

public class BestTimetoBuyandSellStock121
{
    public int maxProfit(int[] prices)
    {
        if (prices.length <= 1)
            return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++)
        {
            min = Math.min(prices[i - 1], min);
            max = Math.max(prices[i] - min, max);
        }

        return max;
    }
}

