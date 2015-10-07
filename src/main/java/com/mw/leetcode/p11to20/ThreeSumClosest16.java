package com.mw.leetcode.p11to20;

import java.util.Arrays;

public class ThreeSumClosest16
{
    public static int threeSumClosest(int[] nums, int target)
    {
        if (nums.length < 3)
            return 0;

        int min = Integer.MAX_VALUE; // Min Diff
        int val = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i == 0 || nums[i] > nums[i - 1])
            {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = sum - target;

                    if (diff == 0)
                    {
                        return sum;
                    }

                    int abs = Math.abs(diff);

                    if (min == abs)
                    {
                        if (diff > 0)
                        {
                            while(j < k && nums[k - 1] == nums[k])
                                k--;
                            k--;
                        }
                        else
                        {
                            while(j < k && nums[j + 1] == nums[j])
                                j++;
                            j++;
                        }
                    }
                    else if (abs > min)
                    {
                        if (diff > 0)
                        {
                            while(j < k && nums[k - 1] == nums[k])
                                k--;
                            k--;
                        }
                        else
                        {
                            while(j < k && nums[j + 1] == nums[j])
                                j++;
                            j++;
                        }
                    }
                    else
                    {
                        val = sum;
                        min = Math.min(abs, min);

                        if (diff > 0)
                        {
                            while(j < k && nums[k - 1] == nums[k])
                                k--;
                            k--;
                        }
                        else
                        {
                            while(j < k && nums[j + 1] == nums[j])
                                j++;
                            j++;
                        }
                    }
                }
            }
        }
        return val;
    }

    public static void main(String[] args)
    {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums, -2));
    }
}
