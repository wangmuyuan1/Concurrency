package com.mw.leetcode.p181to190;

public class RotateArray
{
    public void rotate(int[] nums, int k)
    {
        k %= nums.length;
        // idea 1: reverse last k element and first nums.length - k elements and then reverse the entire string.
        // idea 2: rotate twice.
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
