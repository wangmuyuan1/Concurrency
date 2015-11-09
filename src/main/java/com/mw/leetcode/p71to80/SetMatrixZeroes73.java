package com.mw.leetcode.p71to80;

public class SetMatrixZeroes73
{
    public static void setZeroes(int[][] matrix) {
        int rownum = matrix.length;
        if (rownum == 0) return;
        int colnum = matrix[0].length;
        if (colnum == 0) return;

        // check if the first col has zero as it will be overwrite later
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int i = 0; i < rownum; i++)
        {
            if (matrix[i][0] == 0)
            {
                firstColHasZero = true;
                break;
            }
        }

        // check if the first row has zero as it will be overwrite later
        for (int j = 0; j < colnum; j++)
        {
            if (matrix[0][j] == 0)
            {
                firstRowHasZero = true;
                break;
            }
        }

        // for each cell, if it is zero, set the col and row cell
        for (int i = 0; i < rownum; i++)
        {
            for (int j = 0; j < colnum; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // if row[0] == 0, set entire row = 0
        for (int i = 1; i < rownum; i++)
            if (matrix[i][0] == 0)
                for (int j = 1; j < colnum; j++)
                    matrix[i][j] = 0;

        for (int j = 1; j < colnum; j++)
            if (matrix[0][j] == 0)
                for (int i = 1; i < rownum; i++)
                    matrix[i][j] = 0;

        if (firstRowHasZero)
            for (int j = 0; j < colnum; j++)
                matrix[0][j] = 0;

        if (firstColHasZero)
            for (int i = 0; i < rownum; i++)
                matrix[i][0] = 0;
    }

    public static void main (String[] args)
    {
        int[][] matrix = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}};
        setZeroes(matrix);

        for (int[] row : matrix)
        {
            for (int i : row)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
