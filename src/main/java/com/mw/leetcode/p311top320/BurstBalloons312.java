package com.mw.leetcode.p311top320;

public class BurstBalloons312
{
    public int maxCoinsDpWithRec(int[] nums)
    {
        // create another array to hold.
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++)
            newNums[i + 1] = nums[i];

        int[][] dp = new int[newNums.length][newNums.length];

        return burst(dp, newNums, 0, newNums.length - 1);
    }

    private int burst(int[][] dp, int[] newNums, int left, int right)
    {
        if (left + 1 == right)
            return 0;
        if (dp[left][right] > 0)
            return dp[left][right]; // has been calculated.

        int ans = 0;
        for (int i = left + 1; i < right; i++)
            ans = Math.max(ans, newNums[left] * newNums[i] * newNums[right] + burst(dp, newNums, left, i) +  burst(dp, newNums, i, right));
        dp[left][right] = ans;
        return ans;
    }

    public int maxCoinDp(int[] nums)
    {
        return 0;
    }

    public static void main(String[] args)
    {

    }
}
