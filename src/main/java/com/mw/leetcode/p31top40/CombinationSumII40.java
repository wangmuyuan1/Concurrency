package com.mw.leetcode.p31top40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII40
{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (candidates.length == 0)
            return result;

        Arrays.sort(candidates);
        findCombination(target, candidates, 0, stack, result);

        return result;
    }

    public static void findCombination(int target, int[] candidates, int index, Stack<Integer> stack, List<List<Integer>> result)
    {
        if (target == 0)
        {
            List<Integer> temp = new ArrayList<>(stack);
            result.add(temp);
        }
        else
        {
            for (int i = index; i < candidates.length; i++)
            {
                if (candidates[i] > target)
                {
                    return;
                }
                if (i > index && candidates[i] == candidates[i - 1])
                {
                    continue;
                }

                stack.push(candidates[i]);
                findCombination(target - candidates[i], candidates, i + 1, stack, result);
                stack.pop();
            }
        }
    }
}
