package com.mw.leetcode.p31top40;

public class SearchInRotatedSortedArray33
{
    public static int search(int[] nums, int target)
    {
        if (nums.length == 0)
            return - 1;

        //loop
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // if (nums[mid] == target)
            int mid = (start + end) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }

            if (nums[mid] >= nums[start]) // left sorted.
            {
                if (nums[start] <= target && nums[mid] > target) // find left.
                {
                    end = mid - 1;
                }
                else // find right.
                {
                    start = mid + 1;
                }
            }
            else // right sorted.
            {
                if (nums[mid] < target && nums[end] >= target) // find right.
                {
                    start = mid + 1;
                }
                else // find left
                {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
