package com.mw.leetcode.p301to310;

/**
 * Created by mwang on 11/04/2016.
 */
public class NumArray
{
    private int[] sum; // sum[i + 1] contains the sum from [0 to i].

    public NumArray(int[] nums)
    {
        sum = new int[nums.length + 1];
        if (nums.length > 0)
        {
            sum[0] = 0; // Dummy position.
            for (int i = 1; i <= nums.length; i++)
            {
                sum[i] = nums[i - 1] + sum[i - 1];
            }
        }
    }

    public int sumRange(int i, int j)
    {
        if (sum.length == 0)
            return 0;
        if (i == 0)
            return sum[j + 1];
        return sum[j + 1] - sum[i];
    }

    public static void main(String args[])
    {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        numArray.sumRange(2, 5);
    }
}
