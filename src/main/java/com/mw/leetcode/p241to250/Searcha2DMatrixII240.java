package com.mw.leetcode.p241to250;

/**
 * Created by mwang on 29/04/2016.
 */
public class Searcha2DMatrixII240
{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row < matrix.length)
        {
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };
        Searcha2DMatrixII240 app = new Searcha2DMatrixII240();
        System.out.println(app.searchMatrix(matrix, 29));
    }
}
