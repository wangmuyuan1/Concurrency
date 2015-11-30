package com.mw.leetcode.p131to140;

public class SingleNumber136
{
    public int singleNumber(int[] nums)
    {
        int n = 0;
        for (int i = 0; i < nums.length; i++)
        {
            n ^= nums[i];
        }
        return n;
    }

    public static void main(String[] args)
    {
        int[] nums = {3,9,8,8,1,7,3,9,7};
        System.out.println(new SingleNumber136().singleNumber(nums));
    }
}
