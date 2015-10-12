package com.mw.leetcode.p21top30;

public class RemoveDuplicatesFromSortedArray26
{
    public static int removeDuplicates(int[] nums)
    {

        if (nums.length < 2)
            return nums.length;

        int i = 0;
        int j = 0;
        while (j < nums.length)
        {
            // find next not equals.
            if (nums[i] == nums[j])
            {
                j++;
            }
            else
            {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1};
        System.out.println(removeDuplicates(nums));
    }
}
