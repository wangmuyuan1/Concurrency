package com.mw.leetcode.p321top330;

public class CoinChange322
{
    public int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++)
        {
            int min = Integer.MAX_VALUE;
            for (int coin : coins)
            {
                if (i - coin >= 0 && dp[i - coin] >= 0)
                    min = Math.min(min, dp[i - coin] + 1);
            }
            if (min == Integer.MAX_VALUE)
                min = -1;
            dp[i] = min;
        }

        return dp[amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange322().coinChange(coins, 3));
    }
}
