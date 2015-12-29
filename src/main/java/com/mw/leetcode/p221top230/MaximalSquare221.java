package com.mw.leetcode.p221top230;

public class MaximalSquare221
{
    public int maximalSquare(char[][] matrix)
    {
        int max = 0;
        if (matrix == null || matrix.length == 0)
            return max;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col]; // stores max boundary size to the position.
        int maxsize = 0;
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxsize = Math.max(maxsize, dp[0][j]);
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxsize = Math.max(maxsize, dp[i][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxsize = Math.max(maxsize, dp[i][j]);
                }
            }
        }
        return maxsize * maxsize;
    }

    public static void main(String[] args)
    {
        char[][] matrix =
                {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
                };
        System.out.println(new MaximalSquare221().maximalSquare(matrix));
    }
}
