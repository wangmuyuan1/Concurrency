package com.mw.leetcode.p71to80;

import java.util.ArrayList;
import java.util.List;

public class Combination77
{
    public static List<List<Integer>> combine(int n, int k)
    {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0)
        {
            return result;
        }
        dfs(1, n, k, temp, result);

        return result;
    }

    private static void dfs(int start, int n, int k, List<Integer> temp, List<List<Integer>> result)
    {
        if (k == temp.size())
        {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (Integer i = start; i <= n; i++)
        {
            temp.add(i);
            dfs(i + 1, n, k, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        for (List<Integer> result : combine(4, 2))
        {
            for (Integer i : result)
                System.out.print(i);
            System.out.println();
        }
    }
}
