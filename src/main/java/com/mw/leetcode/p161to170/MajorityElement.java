package com.mw.leetcode.p161to170;

public class MajorityElement
{
    public int majorityElement(int[] nums)
    {
        int max = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++)
        {
            if (count == 0)
            {
                max = nums[i];
                count = 1;
            }
            else if (max == nums[i])
                count++;
            else
                count--;
        }
        return max;
    }
}
