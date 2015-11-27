package com.mw.p151to160;

public class FindMinimuminRotatedSortedArrayII154
{
    public int findMin(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r)
        {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) // left sorted.
                l = m + 1;
            else if (nums[m] < nums[r]) // right sorted.
                r = m;
            else // (nums[m] == []) get rid of the duplicates.
            {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args)
    {

    }
}
