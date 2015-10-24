package com.mw.leetcode.p41to50;

import java.util.*;

public class PermutationII47
{
    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        // we can still do recursive. but should use a visited to keep visited
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        permuteUnique(resultList, result, visited, nums);
        return resultList;
    }

    public static void permuteUnique(List<List<Integer>> resultList, List<Integer> result, boolean[] visited, int[] nums)
    {
        if (result.size() == nums.length)
        {
            resultList.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
            {
                continue;
            }

            visited[i] = true;
            result.add((Integer)nums[i]);
            permuteUnique(resultList, result, visited, nums);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }

    public static List<List<Integer>> permuteUniqueIter(int[] nums)
    {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++)
        {
            Set<List<Integer>> cur = new HashSet<>();
            for (List<Integer> list : resultList)
            {
                for (int j = 0; j < list.size() + 1; j++) //append to end.
                {
                    //Add i into current list.
                    list.add(j, (Integer) nums[i]);
                    cur.add(new ArrayList<>(list));
                    list.remove(j);
                }
            }
            resultList = new ArrayList<>(cur);
        }

        return resultList;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 1, 2};
        for (List<Integer> perm : permuteUniqueIter(array))
        {
            for (int i : perm)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
