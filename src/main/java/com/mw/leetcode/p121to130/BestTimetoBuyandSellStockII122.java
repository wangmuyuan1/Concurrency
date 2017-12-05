package com.mw.leetcode.p121to130;

public class BestTimetoBuyandSellStockII122
{
    public int maxProfit(int[] prices)
    {
        if (prices.length == 0)
            return 0;

        int profit = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < prices[i - 1])
            {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
            else
            {
                min = Math.min(min, prices[i]);
            }
        }

        if (prices[prices.length - 1] != min)
        {
            profit += prices[prices.length - 1] - min;
        }

        return profit;
    }

    public static void main(String[] args)
    {
        BestTimetoBuyandSellStockII122 app = new BestTimetoBuyandSellStockII122();
        int[] array = {7,6,5,4,6,7,5,1,3};
        System.out.println(app.maxProfit(array));

    }
}
