package com.mw.leetcode.p31top40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum39
{
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (candidates.length == 0)
            return result;

        Arrays.sort(candidates);

        findCombination(target, candidates, 0, stack, result);
        return result;
    }

    private static void findCombination(int target, int[] candidates, int index, Stack<Integer> stack, List<List<Integer>> result)
    {
        if (target == 0)
        {
            List<Integer> temp = new ArrayList<>(stack);
            result.add(temp);
        }
        else
        {
            for (int i = index; i < candidates.length; i++) // from current position, go forward.
            {
                if(target < candidates[i]) // if target is 7 and current number is 8, there is no need to go forward.
                    return;

                if (i > index && candidates[i] == candidates[i - 1]) // skip duplicates.
                    continue;

                // push current into stack.
                stack.push(candidates[i]);
                findCombination(target - candidates[i], candidates, i, stack, result); // continue to go forward to find result.
                // at the very end, the stack will be empty.

                // pop current from the stack.
                stack.pop();
            }
        }
    }

    public static void main(String args[])
    {
        int[] array = {10,1,2,7,6,1,5};
        for (List<Integer> item : combinationSum(array, 8))
        {
            for(int i : item)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
