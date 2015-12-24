package com.mw.leetcode.p201to210;

public class MinimumSizeSubarraySum209
{
    public int minSubArrayLen(int s, int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < nums.length)
        {
            while (end < nums.length && sum < s)
                sum += nums[end++];
            if (sum < s)
                break;
            while (start < end && sum >= s)
                sum -= nums[start++];
            minLen = Math.min(minLen, end - start + 1);
        }

        if (minLen < Integer.MAX_VALUE)
            return minLen;
        return 0;
    }

    public static void main(String[] args)
    {
        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        System.out.println(new MinimumSizeSubarraySum209().minSubArrayLen(80, nums));
    }
}
