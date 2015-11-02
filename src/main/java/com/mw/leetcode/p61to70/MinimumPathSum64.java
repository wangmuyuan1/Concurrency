package com.mw.leetcode.p61to70;

public class MinimumPathSum64
{
    public static int minPathSum(int[][] grid)
    {
        if (grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] min = new int[m][n];

        min[0][0] = grid[0][0];

        for (int i = 1; i < m; i++)
        {
            min[i][0] = grid[i][0] + min[i - 1][0];
        }

        for (int j = 1; j < n; j++)
        {
            min[0][j] = grid[0][j] + min[0][j - 1];
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
            }
        }

        return min[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int[][] array = {{1,3,1},
                         {1,5,1},
                         {4,2,1}};
        System.out.println(minPathSum(array));
    }
}
