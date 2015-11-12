package com.mw.leetcode.p71to80;

public class WordSearch79
{
    public static boolean exist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;

        if (m == 0 || n == 0)
            return false;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dfs(0, i, j, board, word))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int index, int row, int col, char[][] board, String word)
    {
        if (index == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;

        char temp = board[row][col];
        board[row][col]='#';

        if (dfs(index + 1, row + 1, col, board, word)
                || dfs(index + 1, row, col + 1, board, word)
                || dfs(index + 1, row - 1, col, board, word)
                || dfs(index + 1, row, col - 1, board, word))
        {
            return true;
        }
        board[row][col] = temp;
        return false;
    }

    public static void main(String[] args)
    {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
