package com.mw.leetcode.p51to60;

public class SpiralMatrixII59
{
    public static int[][] generateMatrix(int n)
    {
        int total = n * n;
        int[][] result = new int[n][n];
        int i = 1;
        int row = 0;
        int col = 0;
        int step = n - 1;
        while (i <= total)
        {
            if (step == 0)
            {
                result[row][col] = i++;
            }

            // top
            for (int curStep = 0; curStep < step && i <= total; curStep++)
            {
                result[row][col++] = i++;
            }

            // right
            for (int curStep = 0; curStep < step && i <= total; curStep++)
            {
                result[row++][col] = i++;
            }

            // bottom
            for (int curStep = 0; curStep < step && i <= total; curStep++)
            {
                result[row][col--] = i++;
            }
            //

            // left
            for (int curStep = 0; curStep < step && i <= total; curStep++)
            {
                result[row--][col] = i++;
            }

            row++;
            col++;
            step -= 2;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[][] result = generateMatrix(0);
        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[0].length; j++)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
