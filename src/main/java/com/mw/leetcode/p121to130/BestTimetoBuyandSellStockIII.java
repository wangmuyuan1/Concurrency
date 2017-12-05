package com.mw.leetcode.p121to130;

public class BestTimetoBuyandSellStockIII
{
    public int maxProfit(int[] prices)
    {
        int sell1 = 0;
        int sell2 = 0;
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++)
        {
            buy1 = Math.max(buy1, -prices[i]); // what is the lowest point if I only buy 1 time at the point of i.
            sell1 = Math.max(sell1, buy1 + prices[i]); // what is the max profit if I only sell 1 time at the point of i.
            buy2 = Math.max(buy2, sell1 - prices[i]); // what is the lowest point if I only buy 2 times at the point of i.
            sell2 = Math.max(sell2, buy2 + prices[i]); // what is the max profit if I only sell 2 times at the point of i.
        }
        return sell2;
    }

    public static void main(String[] args)
    {
        BestTimetoBuyandSellStockIII app = new BestTimetoBuyandSellStockIII();
        int[] array = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(app.maxProfit(array));
    }
}
