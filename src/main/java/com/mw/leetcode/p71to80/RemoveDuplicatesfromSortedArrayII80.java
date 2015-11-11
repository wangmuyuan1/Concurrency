package com.mw.leetcode.p71to80;

public class RemoveDuplicatesfromSortedArrayII80
{
    public static int removeDuplicates(int[] nums)
    {
        int result = 0;

        if (nums.length == 0)
            return result;

        int cur = Integer.MIN_VALUE;
        int count = 0;
        int length = 0;
        int repStart = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != cur)
            {
                cur = nums[i];
                count = 1;
                length++;

                if (repStart > 0)
                {
                    swap(nums, repStart, i);
                    if (repStart < nums.length && nums[repStart + 1] != cur)
                        repStart++;
                }
            }
            else if (count == 1)
            {
                count++;
                length++;
                if (repStart > 0)
                {
                    swap(nums, repStart, i);
                    if (repStart < nums.length && nums[repStart + 1] != cur)
                        repStart++;
                }
            }
            else
            {
                if (repStart == -1)
                    repStart = i;
            }
        }
        return length;
    }

    private static void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
