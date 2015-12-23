package com.mw.leetcode.p211to220;

public class HouseRobberII
{
    public int rob(int[] nums)
    {
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int nums[], int start, int end)
    {
        if (nums.length == 0 || start == nums.length)
            return 0;

        if (start >= end - 1)
            return nums[start];

        int[] dp = new int[nums.length];
        // dp[i] means max profit from 0.
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++)
        {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = {1};
        System.out.println(new HouseRobberII().rob(nums));
    }
}
