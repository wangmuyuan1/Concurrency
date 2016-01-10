package com.mw.leetcode.p321top330;

import com.mw.ProjectUtil;

import java.util.Arrays;

public class WaggleSort324
{
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        int[] first = Arrays.copyOfRange(nums, 0, mid);
        int[] second = Arrays.copyOfRange(nums, mid, nums.length);

        int i = first.length - 1, j = second.length - 1, k = 0;
        while (i >= 0 || j >= 0)
        {
            if (i >= 0)
                nums[k++] = first[i--];
            if (j >= 0)
                nums[k++] = second[j--];
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,2,1,2,2,1};
        new WaggleSort324().wiggleSort(nums);
        ProjectUtil.printIntArray(nums);
    }
}
