package com.mw.leetcode.p321top330;

public class PatchingArray330
{
    public int minPatches(int[] nums, int n)
    {
        long miss = 1; // The first missing value from [0 to x)
        int added = 0; // the added patch;
        int i = 0;

        while (miss <= n)
        {
            if (i < nums.length && nums[i] <= miss) // miss is in the right hand side of nums i, means left hand side is full match.
                miss += nums[i++]; // move to next potential value that is miss.
            else
            {
                miss += miss;
                added++; // insert a patch.
            }
        }

        return added;
    }
}
