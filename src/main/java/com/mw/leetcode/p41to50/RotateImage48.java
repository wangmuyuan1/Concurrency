package com.mw.leetcode.p41to50;

public class RotateImage48
{
    // Rotate the image is start from the n/2
    public static void rotate(int[][] matrix)
    {
        int n = matrix.length;

        if (n <= 1)
        {
            return;
        }

        for (int i = 0; i <= (n - 1) / 2; i++)
        {
            for (int j = 0; j <= n / 2 - 1; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2},
                {3, 4}
                };
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                };

        rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++)
        {
            for (int j = 0; j < matrix2.length; j++)
            {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
