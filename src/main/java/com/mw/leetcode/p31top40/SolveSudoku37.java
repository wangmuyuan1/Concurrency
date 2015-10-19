package com.mw.leetcode.p31top40;

public class SolveSudoku37
{
    public static void solveSudoku(char[][] board)
    {
        // For each cell.
        // if it is . try 1 - 9.
        // validate the result.
        // if it is valid, go deeper.
        dfs(board, 0);
    }

    private static boolean dfs(char[][] board, int cur)
    {
        if (cur == 81) // last cell was reached.
        {
            return true;
        }

        int row = cur / 9;
        int col = cur % 9;

        if (board[row][col] == '.')
        {
            for (char i = '1'; i <= '9'; i++)
            {
                if (isValid(board, row, col, i)) // if it is valid.
                {
                    board[row][col] = i;
                    if (dfs(board, cur + 1)) // if dfs true. revert.
                    {
                        return true;
                    }
                    else
                    {
                        board[row][col] = '.';
                    }
                }
            }

            return false;
        }
        else // if it is not, then skip
        {
            return dfs(board, cur + 1);
        }

        //return true;
    }

    private static boolean isValid(char[][] board, int row, int col, int val)
    {
        for (int i = 0; i < 9; i++)
        {
            if (board[row][i] == val)
                return false;
        }

        for (int i = 0; i < 9; i++)
        {
            if (board[i][col] == val)
                return false;
        }

        // this is wrong.
        // find start point.
        int startRow = row / 3;
        int startCol = col / 3;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[startRow * 3 + i][startCol * 3 + j] == val)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {

        String[] a = {
                "..9748...",
                "7........",
                ".2.1.9...",
                "..7...24.",
                ".64.1.59.",
                ".98...3..",
                "...8.3.2.",
                "........6",
                "...2759.."};
        char[][] board = new char[9][9];
        for ( int i = 0; i < 9; i++)
        {
            board[i] = a[i].toCharArray();
        }
        solveSudoku(board);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
