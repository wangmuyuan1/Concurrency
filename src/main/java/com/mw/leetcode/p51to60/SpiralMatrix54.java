package com.mw.leetcode.p51to60;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54
{
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
        {
            return result;
        }

        int m = matrix.length; // m row
        int n = matrix[0].length; // n col
        if (n == 0)
        {
            return result;
        }

        int x = 0;
        int y = 0;
        while (m > 0 && n > 0)
        {
            if (m == 1) // no m left. add all col.
            {
                for (int i = 0; i < n; i++) // need to be n times, because we dont go other direction.
                {
                    result.add(matrix[x][y++]);
                }
                break;
            }
            else if (n == 1) // no n left, add all row.
            {
                for (int i = 0; i < m; i++) // need to be m times, because we dont go direction.
                {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // top.
            for (int i = 0; i < n - 1; i++) // repeat n - 2 times but start from x, not 0
            {
                result.add(matrix[x][y++]);
            }
            // right.
            for (int i = 0; i < m - 1; i++) // repeat n - 2 times but start from y, not 0
            {
                result.add(matrix[x++][y]);
            }
            // bottom.
            for (int i = 0; i < n - 1; i++)
            {
                result.add(matrix[x][y--]);
            }
            // left.
            for (int i = 0; i < m - 1; i++)
            {
                result.add(matrix[x--][y]);
            }

            // after the loop. the x and y are back to left-top corner.
            x++;
            y++;

            // we reduce the times that needs to be looped.
            m -= 2;
            n -= 2;
        }


        return result;
    }

    public static void main(String[] args)
    {

    }
}
