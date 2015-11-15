package com.mw.leetcode.p81to90;

import java.util.Stack;

public class MaximalRectangle85
{
    public static int maximalRectangle(char[][] matrix)
    {
        int max = 0;
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0)
            return max;

        int[][] height = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '0')
                {
                    height[i][j] = 0;
                }
                else
                {
                    height[i][j] = (i==0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            int area = maxAreaInHist(height[i]);
            max = Math.max(area, max);
        }

        return max;
    }

    private static int maxAreaInHist(int[] height)
    {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int max = 0;

        while (i < height.length)
        {
            if (stack.isEmpty() || height[stack.peek()] > height[i])
                stack.push(i++);
            else
            {
                int t = stack.pop();
                max = Math.max(max,
                        height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }

    public static void main(String[] args)
    {

    }
}
