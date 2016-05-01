package com.mw.leetcode.p281to290;

/**
 * Created by mwang on 29/04/2016.
 */
public class MoveZeroes283
{
    public void moveZeroes(int[] nums)
    {
        int idx = 0;
        for (int num : nums)
            if (num != 0) nums[idx++] = num;

        while (idx < nums.length)
            nums[idx++] = 0;
    }
}
