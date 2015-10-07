package com.mw.leetcode.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18
{
    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++)
        {
            if (i == 0 || nums[i] > nums[i - 1])
            {
                for (int j = i + 1; j < nums.length - 2; j++)
                {
                    if (j == i + 1 || nums[j] > nums[j - 1])
                    {
                        int k = j + 1;
                        int l = nums.length - 1;

                        while (k < l)
                        {
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if (sum == target)
                            {
                                List<Integer> temp = new ArrayList<>();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(nums[k]);
                                temp.add(nums[l]);
                                result.add(temp);
                                while (k < l && nums[k] == nums[k + 1])
                                {
                                    k++;
                                }
                                k++;
                                while (k < l && nums[l] == nums[l - 1])
                                {
                                    l--;
                                }
                                l--;
                            }
                            else if (sum > target)
                            {
                                while (k < l && nums[l] == nums[l - 1])
                                {
                                    l--;
                                }
                                l--;
                            }
                            else
                            {
                                while (k < l && nums[k] == nums[k + 1])
                                {
                                    k++;
                                }
                                k++;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        print(fourSum(nums, 2));
    }

    public static void print(List<List<Integer>> results)
    {
        for (List<Integer> result: results)
        {
            for (int num : result)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
