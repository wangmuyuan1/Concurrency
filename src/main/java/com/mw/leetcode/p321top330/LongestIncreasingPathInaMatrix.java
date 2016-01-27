package com.mw.leetcode.p321top330;

public class LongestIncreasingPathInaMatrix
{
    public int longestIncreasingPath(int[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 1;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int len = dfs(matrix, i, j, m, n, dp);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp)
    {
        // save the result of dfs into dp, then next time we hit that cell we can get max straight away.
        if (dp[i][j] > 0)
            return dp[i][j];

        int max = 1; // at least 1.
        // check left,
        if (i - 1 >= 0 && i - 1 < m && matrix[i - 1][j] > matrix[i][j]) // left
            max = Math.max(max, 1 + dfs(matrix, i - 1, j, m, n, dp));
        if (j - 1 >= 0 && j - 1 < n && matrix[i][j - 1] > matrix[i][j]) // up
            max = Math.max(max, 1 + dfs(matrix, i, j - 1, m, n, dp));
        if (i + 1 >= 0 && i + 1 < m && matrix[i + 1][j] > matrix[i][j])
            max = Math.max(max, 1 + dfs(matrix, i + 1, j, m, n, dp));
        if (j + 1 >= 0 && j + 1 < n && matrix[i][j + 1] > matrix[i][j])
            max = Math.max(max, 1 + dfs(matrix, i, j + 1, m, n, dp));

        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args)
    {
        int[][] nums = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        System.out.println(new LongestIncreasingPathInaMatrix().longestIncreasingPath(nums));
    }
}
