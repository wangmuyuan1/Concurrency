package com.mw.leetcode.p41to50;

import java.util.ArrayList;
import java.util.List;

public class Permutations46
{
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> itemList = new ArrayList<>();
        return permute(resultList, itemList, nums);
    }

    /**
     * Recursive.
     */
    private static List<List<Integer>> permute(List<List<Integer>> resultList, List<Integer> itemList, int[] nums)
    {
        if (itemList.size() == nums.length)
        {
            resultList.add(new ArrayList<>(itemList));
            return resultList;
        }

        for (Integer num : nums)
        {
            if (itemList.contains(num))
            {
                continue;
            }

            itemList.add(num);
            permute(resultList, itemList, nums);
            itemList.remove(num);
        }
        return resultList;
    }

    /**
     * Iter
     */
    public static List<List<Integer>> permuteIter(int[] nums)
    {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>()); //start from empty list

        for (int i = 0; i < nums.length; i++)
        {
            // for every index in num, we create a brand new result sets.
            List<List<Integer>> current = new ArrayList<>();

            // for every result from last result set.
            for (List<Integer> result : resultList)
            {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < result.size() + 1; j++)
                {
                    // we dynamically add num[i] to different locations for given result.
                    result.add(j, nums[i]);

                    List<Integer> temp = new ArrayList<>(result);
                    current.add(temp);

                    // - remove num[i] add
                    result.remove(j);
                }
            }

            resultList = new ArrayList<>(current);
        }
        return resultList;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 2, 3};
        for (List<Integer> perm : permuteIter(array))
        {
            for (int i : perm)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
