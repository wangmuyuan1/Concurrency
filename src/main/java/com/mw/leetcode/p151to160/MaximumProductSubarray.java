package com.mw.leetcode.p151to160;

public class MaximumProductSubarray
{
    public int maxProduct(int[] nums)
    {
        if (nums.length == 0)
            return 0;

        int max = nums[0];
        int min = nums[0];
        int r = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]); // 对于第一个负数，max为负数本身， min为min * nums[i],
            min = Math.min(min * nums[i], nums[i]); //
            r = Math.max(r, max); // 如果遇见负数，r还是为正。
        }
        return r;
    }
}
