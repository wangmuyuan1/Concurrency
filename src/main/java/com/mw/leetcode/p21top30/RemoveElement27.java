package com.mw.leetcode.p21top30;

public class RemoveElement27
{
    public int removeElement(int[] nums, int val)
    {
        int i = 0; // Current.
        int j = 0; // Not equal to val.

        while (j < nums.length)
        {
            if (nums[j] != val)
            {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
