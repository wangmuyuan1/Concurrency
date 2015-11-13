package com.mw.leetcode.p81to90;

public class SearchinRotatedSortedArrayII81
{
    public static boolean search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (mid > left && nums[mid] == nums[left])
        {
            left++;
        }

        while (mid < right && nums[mid] == nums[right])
        {
            right--;
        }

        while (left <= right)
        {
            mid = (left + right) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] > nums[left]) // left sorted.
            {
                if (nums[left] == target)
                    return true;

                if (nums[mid] > target && nums[left] < target) // make sure it is in the range.
                {
                    right = mid - 1;
                }
                else // if it is definately not, find right.
                {
                    left = mid + 1;
                }
            }
            else // right sorted.
            {
                if (nums[right] == target)
                    return true;

                if (nums[mid] < target && nums[right] > target) // make sure it is in the range.
                {
                    left = mid + 1;
                }
                else // if it is definately not, find left.
                {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,3,1,1,1};
        System.out.println(search(nums, 3));
    }
}
