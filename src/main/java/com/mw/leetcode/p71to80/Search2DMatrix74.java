package com.mw.leetcode.p71to80;

public class Search2DMatrix74
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        // locate row.
        if (matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        int rownum = matrix.length;
        int colnum = matrix[0].length;

        int start = 0;
        int mid = rownum / 2;
        int end = rownum - 1;
        while (start <= end)
        {
            if (target == matrix[mid][0])
                return true;
            else if (target < matrix[mid][0])
            {
                end = mid - 1;
                mid = (end + start) / 2;
            }
            else
            {
                if (target == matrix[mid][colnum - 1])
                    return true;
                else if (target < matrix[mid][colnum - 1])
                {
                    // search current row.
                    int left = 0;
                    int right = colnum - 1;
                    int central = (left + right) / 2;
                    while (left <= right)
                    {
                        if (target == matrix[mid][central])
                            return true;
                        else if (target < matrix[mid][central])
                        {
                            right = central - 1;
                            central = (right + left) / 2;
                        }
                        else
                        {
                            left = central + 1;
                            central = (right + left) / 2;
                        }
                    }
                    start = mid + 1;
                    mid = (end + start) / 2;
                }
                else
                {
                    start = mid + 1;
                    mid = (end + start) / 2;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
            };
        System.out.println(searchMatrix(matrix, 17));
    }
}
