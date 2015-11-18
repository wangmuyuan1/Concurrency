package com.mw.leetcode.p121to130;

public class BestTimetoBuyandSellStockIII
{
    public static int maxProfit(int[] prices)
    {
        if (prices.length == 0)
            return 0;
        int[] fromLeft = new int[prices.length];
        int[] toRight = new int[prices.length];
        int maxProfit = 0;
        int max = prices[prices.length - 1];
        int min = prices[0];
        for (int i = 0; i < prices.length; i++)
        {
            min = Math.min(prices[i], min);
            maxProfit = Math.max(prices[i] - min, maxProfit);
            fromLeft[i] = maxProfit;
        }

        maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--)
        {
            max = Math.max(prices[i], max);
            maxProfit = Math.max(max - prices[i], maxProfit);
            toRight[i] = maxProfit;
        }

        maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++)
        {
            maxProfit = Math.max(fromLeft[i] + toRight[i], maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args)
    {

    }
}
