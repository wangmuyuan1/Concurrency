package com.mw.leetcode.p301to310;

/**
 * Created by mwang on 11/04/2016.
 */
public class NumMatrix
{
    private int sum[][]; // stores the sum of the value from 0,0 to row, col

    public NumMatrix(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            sum = null;
            return;
        }
        sum = new int[matrix.length][matrix[0].length];

        sum[0][0] = matrix[0][0];

        for (int i = 1; i < matrix.length; i++)
            sum[i][0] = matrix[i][0] + sum[i - 1][0];

        for (int j = 1; j < matrix[0].length; j++)
            sum[0][j] = matrix[0][j] + sum[0][j - 1];

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null)
            return 0;

        if (row1 == 0 && col1 == 0) return sum[row2][col2];
        if (row1 == 0)
            return sum[row2][col2] - sum[row2][col1 - 1];
        if (col1 == 0)
            return sum[row2][col2] - sum[row1 - 1][col2];

        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }

    public static void main(String[] args)
    {
//        int matrix[][] = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
//
//        NumMatrix app = new NumMatrix(matrix);
//        System.out.println(app.sumRegion(2, 1, 4, 3));
//        System.out.println(app.sumRegion(1, 1, 2, 2));
//        System.out.println(app.sumRegion(1, 2, 2, 4));
        int matrix[][] = {{-4, -5}};
        NumMatrix app = new NumMatrix(matrix);
        System.out.println(app.sumRegion(0, 0, 0, 1));
    }
}
