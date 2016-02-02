package com.mw.leetcode.p11to20;

import java.util.Arrays;

public class ThreeSumClosest16
{
    public int threeSumClosest(int[] num, int target)
    {
        int result = num[0] + num[1] + num[num.length - 1]; // 0, 1 and last.
        // Sort Array.
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++)
        {
            int start = i + 1; int end = num.length - 1;
            while(start < end)
            {
                int sum = num[i] + num[start] + num[end];
                if (sum > target)
                    end--;
                else
                    start++;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(new ThreeSumClosest16().threeSumClosest(nums, -2));
    }
}
