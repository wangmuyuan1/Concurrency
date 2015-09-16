package com.mw.leetcode.p31top40;

public class NextPermutation31
{
    public static void nextPermutation(int[] nums)
    {
        // Step 1: from right to left, find first number that is lesser than its successor. and this is then the cut point.
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if (nums[i] < nums[i + 1])
            {
                pivot = i;
                break;
            }
        }

        if (pivot > -1)
        {
            // Step 2: from right to left, find first number that is greater than the pivot. swap.
            for (int i = nums.length - 1; i >= pivot; i--)
            {
                if (nums[i] > nums[pivot])
                {
                    int tmp = nums[pivot];
                    nums[pivot] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }

            // Step 3: reverse the number from pivot + 1 to end.
            for (int i = pivot + 1, j = nums.length - 1; i < j; i++, j--)
            {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        else
        {
            // Step 3: reverse the number from pivot + 1 to end.
            for (int i = pivot + 1, j = nums.length - 1; i < j; i++, j--)
            {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i : nums)
        {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] a1 = {1, 3, 2};
        nextPermutation(a1);
    }
}
