package com.mw.leetcode.p71to80;

public class SortColors75
{
    public static void sortColors(int[] nums)
    {
        if(nums==null || nums.length<2)
            return;

        int[] color = new int[3];
        for (int i : nums)
        {
            color[i]++;
        }

        int j = 0, k = 0;
        while (j <= 2)
        {
            if (color[j] > 0)
            {
                nums[k++] = j;
                color[j]--;
            }
            else
                j++;
        }
    }
}
