package com.mw.leetcode.p161to170;

public class FindPeakElement162
{
    public int findPeakElement(int[] nums)
    {
        int l = 0;
        int r = nums.length - 1;
        while (l < r)
        {
            int mid1 = l + (r - l) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] <= nums[mid2])
            {
                // peak on right hand side.
                l = mid2;
            }
            else
            {
                // peak on left hand side.
                r = mid1;
            }
        }
        return l;
    }
}
