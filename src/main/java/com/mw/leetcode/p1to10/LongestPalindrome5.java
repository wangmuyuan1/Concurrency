package com.mw.leetcode.p1to10;

public class LongestPalindrome5
{
    public static String longestPalindrome(String s)
    {
        char[] array = s.toCharArray();
        // We init a matrix[j][i] where i is the starting of the index and j is the length.
        boolean[][] matrix = new boolean[array.length][array.length];

        // Every character itself is a palindrome.
        for (int i = 0; i < array.length; i++)
        {
            matrix[0][i] = true; // for every character, extend 0 step. we can find a palindrome.
        }

        // Check if its neighbour is same as itself.
        for (int i = 0; i < array.length - 1; i++)
        {
            matrix[1][i] = (array[i] == array[i + 1]); // for every character except the last one, extend 1 step. we can find a palindrome.
        }

        // Check how long we can extend.
        for (int j = 2; j < array.length; j++)
        {
            for (int i = 0; i < array.length - j; i++)
            {
                // i and i + j means a step expanding from i + 1 to i + j - 1.
                // eg. matrix[2][0] = (array[0] == array[2]) && matrix[0][1]
                // eg. matrix[3][0] = (array[0] == array[3]) && matrix[1][1]
                // eg. matrix[4][0] = (array[0] == array[4]) && matrix[2][1]
                matrix[j][i] = (array[i] == array[i + j]) && matrix[j - 2][i + 1];
            }
        }

        // Check the longest. because j
        int start = 0;
        int length = 0;
        for (int j = 0; j < array.length; j++)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (matrix[j][i])
                {
                    start = i;
                    length = j;
                    break;
                }
            }
        }

        return s.substring(start, start + length + 1);
    }

    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("acc"));
        System.out.println(longestPalindrome("cuyabbaydd"));
    }
}
