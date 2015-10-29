package com.mw.leetcode.p51to60;

import java.util.ArrayList;
import java.util.List;

public class NQueens51
{
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();

        int[] item = new int[n]; // each item is a row, item[i] means the col of the row stores Q.
        dfs(result, item, 0, 0, n);

        return result;
    }

    private static void dfs(List<List<String>> result, int[] item, int row, int count, int n)
    {
        if (n == count)
        {
            // found solution.
            result.add(toStringList(item));
        }

        if (row == n)
        {
            return;
        }

        for (int i = 0; i < n; i++)
        {
            item[row] = i; // put Q at i position of the row.
            if (isValid(item, row, i)) // if valid, move forward.
            {
                dfs(result, item, row + 1, count + 1, n);
            }
            // either success or not, we will try next col.
        }
    }

    private static List<String> toStringList(int[] item)
    {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < item.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < item.length; j++)
            {
                if (j == item[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            result.add(sb.toString());
        }

        return result;
    }

    private static boolean isValid(int[] item, int row, int col)
    {
        // two condition to be invalid.
        for (int i = 0; i < row; i++)
        {
            if (
                    item[i] == item[row] // placed in the same col.
                    || Math.abs(item[i] - item[row]) == row - i // placed in diagonals, could be either direction.
                    )
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        List<List<String>> result = solveNQueens(8);
        for (List<String> res : result)
        {
            for (String s : res)
            {
                System.out.println(s);
            }

            System.out.println();
        }
    }
}
