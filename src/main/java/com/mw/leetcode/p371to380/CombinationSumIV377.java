package com.mw.leetcode.p371to380;

import java.util.Arrays;

public class CombinationSumIV377
{
    class Solution
    {
        public int combinationSum4(int[] nums, int target)
        {
            Arrays.sort(nums);
            int[] dp = new int[target + 1];

            for (int i = 1; i < dp.length; i++)
            {
                for (int num : nums)
                {
                    if (num > i)
                        break;
                    else if (num == i)
                        dp[i]++;
                    else
                        dp[i] = dp[i] + dp[i - num];
                }
            }
            return 0;
        }
    }

    public static void main(String[] args)
    {

    }
}
