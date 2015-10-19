package com.mw.leetcode.p31top40;

public class SearchInsertPosition35
{
    public static int searchInsert(int[] nums, int target)
    {
        if (nums.length == 0)
        {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }

            if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args)
    {
        int[] array = {8};
        System.out.println(searchInsert(array, 7));
    }
}
