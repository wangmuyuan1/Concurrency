package com.mw.leetcode.p71to80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78
{
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        Arrays.sort(nums);
        dfs(nums, 0, temp, result);
        result.add(new ArrayList<>());
        return result;
    }

    private static void dfs(int[] nums, int start, List<Integer> temp, List<List<Integer>> result)
    {
        for(int i = start; i < nums.length;i++){
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            dfs(nums, i+ 1, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
