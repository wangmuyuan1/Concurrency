package com.mw.leetcode.p211to220;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();

        // idea, dfs + skipping
        dfs(result, new ArrayList<>(), 0, 0, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curList, int last, int curSum, int targetSize, int targetSum)
    {
        if (curSum == targetSum && curList.size() == targetSize)
        {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = last + 1; i <= 9; i++)
        {
            if (curSum + i > targetSum)
                break;
            curList.add(new Integer(i));
            dfs(result, curList, i, curSum + i, targetSize, targetSum);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(new CombinationSumIII216().combinationSum3(3, 9));
    }
}
