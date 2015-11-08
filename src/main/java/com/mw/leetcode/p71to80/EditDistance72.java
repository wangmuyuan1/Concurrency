package com.mw.leetcode.p71to80;

public class EditDistance72
{
    public static int minDistance(String word1, String word2)
    {
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++)
        {
            matrix[i][0] = matrix[i - 1][0] + 1; // if word2 is 0 length, how many step will turn word1 to word2.
        }

        for (int j = 1; j <= word2.length(); j++)
        {
            matrix[0][j] = matrix[0][j - 1] + 1; // if word1 is 0 length, how many step will turn word1 to word2.
        }

        for (int i = 1; i <= word1.length(); i++)
        {
            for (int j = 1; j <= word2.length(); j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    matrix[i][j] = matrix[i - 1][j - 1]; //no change.
                }
                else // the char is not equals
                {
                    int add = matrix[i][j - 1] + 1; // del word1.charAt(i - 1) from word 1 = add a char word1.charAt(i - 1) to word 2.
                    int del = matrix[i - 1][j] + 1; // insert word2.char(j - 1) to word 1, so i++;
                    int replace = matrix[i - 1][j - 1] + 1;

                    matrix[i][j] = Math.min(Math.min(del, add), replace);
                }
            }
        }

        return matrix[word1.length()][word2.length()];
    }

    public static void main(String[] args)
    {
        System.out.println(minDistance("ab", "ac"));
    }
}
