package com.mw.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution
{
    /**
     * Space complexity 0
     * Time complexity n2
     */
    public static int[] twoSumBrutal(int[] nums, int target)
    {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSumOptimal(int[] nums, int target)
    {
        int[] result = new int[2];
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (valueMap.containsKey(nums[i]))
            {
                result[0] = valueMap.get(nums[i]) + 1;
                result[1] = i + 1;
                break;
            }
            else
            {
                valueMap.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] numbers = {3, 2, 4};
        int[] result = twoSumOptimal(numbers, 6);
        System.out.println("index1 = " + result[0]);
        System.out.println("index2 = " + result[1]);
    }
}