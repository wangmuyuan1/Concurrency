package com.mw.leetcode.p51to60;

public class NQueens52
{
    public static int totalNQueens(int n)
    {
        int[] result = {0};

        int[] item = new int[n]; // each item is a row, item[i] means the col of the row stores Q.
        dfs(result, item, 0, 0, n);

        return result[0];
    }

    private static void dfs(int[] result, int[] item, int row, int count, int n)
    {
        if (n == count)
        {
            // found solution.
            result[0] += 1;
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
}
