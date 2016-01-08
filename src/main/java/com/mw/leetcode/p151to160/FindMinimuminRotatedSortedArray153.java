package com.mw.leetcode.p151to160;

public class FindMinimuminRotatedSortedArray153
{
    public int findMin(int[] nums)
    {
        if (nums.length == 0)
            return 0;

        int l = 0;
        int r = nums.length - 1;
        while (l < r)
        {
            if (nums[l] < nums[r])
                return nums[l];

            int m = (l + r) / 2;
            if (nums[m] >= nums[l]) // left sorted. we need search right. we use equals because m could == l
                l = m + 1;
            else // right sorted. we need search left.
                r = m;
        }
        return nums[l];
    }
}
