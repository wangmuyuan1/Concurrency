package com.mw.leetcode.p261top270;

/**
 * Created by mwang on 19/04/2016.
 */
public class MissingNumber268
{
    public int missingNumber(int[] nums) {
        int sum = nums.length; // n
        for (int i = 0; i < nums.length; i++)
        {
            sum = sum + i - nums[i];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] nums = {0, 1, 3};
        MissingNumber268 app = new MissingNumber268();
        System.out.println(app.missingNumber(nums));
    }
}
