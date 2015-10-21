package com.mw.leetcode.p41to50;

public class FirstMissingPositive41
{
    public static int firstMissingPositive(int[] nums)
    {
        if (nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0 && nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i])
                // nums[i] - 1 >= 0 && nums[i] - 1 < nums.length check the boundary.
            // nums[nums[i] - 1] != nums[i] skips the unnecessary swap.
            {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--; // stay in current position.
            }
        }

        // Scan again.
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args)
    {
        int[] array = {0};
        System.out.println(firstMissingPositive(array));
    }
}
