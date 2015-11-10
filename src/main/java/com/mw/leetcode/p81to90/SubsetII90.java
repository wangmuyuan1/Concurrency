package com.mw.leetcode.p81to90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII90
{
    // We still use the dfs method.
    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums); // need to sort array to remove duplicates.

        dfs(0, nums, temp, result);
        result.add(new ArrayList<>()); // add empty solution.
        return result;
    }

    private static void dfs(int length, int[] nums, List<Integer> temp, List<List<Integer>> result)
    {
        if (length == nums.length)
        {
            return;
        }

        int last = Integer.MAX_VALUE;
        for (int i = length; i < nums.length; i++)
        {
            // add number to temp.
            if (nums[i] == last)
                continue;

            last = nums[i];
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp)); // add current result.
            dfs(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {0};
        for (List<Integer> result : subsetsWithDup(nums))
        {
            for (Integer i : result)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
