package com.mw.leetcode.p51to60;

public class MaximumSubarray53
{
    public static int maxSubArray(int[] nums)
    {
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            curSum = Math.max(curSum + nums[i], nums[i]);
            max = Math.max(max, curSum);
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
