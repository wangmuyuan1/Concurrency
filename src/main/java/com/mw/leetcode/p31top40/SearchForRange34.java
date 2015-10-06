package com.mw.leetcode.p31top40;

import java.util.Arrays;

public class SearchForRange34
{
    public static int[] searchRange(int[] nums, int target)
    {
        int[] result = {-1, -1};

        if (nums.length == 0)
        {
            return result;
        }

        if (nums.length == 1)
        {
            return (nums[0] == target) ? new int[2] : result;
        }

        // Find the target first.
        int i = Arrays.binarySearch(nums, target); //log(n)

        if (i >= 0)
        {
            // Find the target left.
            int left = i >> 1;
            int right = (i + nums.length) >> 1;

            int rightMostToLeft = i;
            while (left < rightMostToLeft && (nums[left] == target || (nums[left] != target && nums[left + 1] != target)))
            {
                if (nums[left] == target)
                {
                    if (left == 0) break;
                    rightMostToLeft = left;
                    left = left >> 1;
                }
                else
                {
                    left = left + rightMostToLeft >> 1;
                }
            }

            int leftMostToRight = i;
            while (right > leftMostToRight && (nums[right] == target || (nums[right] != target && nums[right - 1] != target)))
            {
                int temp = ((nums[right] == target) ? (right + nums.length) : (right + leftMostToRight)) >> 1;
                if (right == temp)
                {
                    break;
                }
                else
                {
                    leftMostToRight = (temp > right) ? right : leftMostToRight;
                    right = temp;
                }
            }

            result[0] = (nums[left] == target) ? left : left + 1;
            result[1] = (nums[right] == target) ? right : right - 1;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] input = {1};
        int[] result = searchRange(input, 1);
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }
}
