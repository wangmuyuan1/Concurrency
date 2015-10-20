package com.mw.leetcode.p121to130;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions130
{
    public static void solve(char[][] board)
    {
        if (board == null || board.length == 0)
            return;

        int maxRow = board.length;
        int maxCol = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < maxRow; i++)
        {
            if (board[i][0] == 'O') // right column
                bfs(board, queue, i, 0);

            if (board[i][maxCol - 1] == 'O') // left column
                bfs(board, queue, i, maxCol - 1);
        }

        for (int i = 0; i < maxCol; i++)
        {
            if (board[0][i] == 'O') // top row.
                bfs(board, queue, 0, i);

            if (board[maxRow - 1][i] == 'O') // bottom row.
                bfs(board, queue, maxRow - 1, i);
        }

        // Only need to bfs from the boarders as any O not connecting to boarder will definitely surrounded by X.

        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'P')
                    board[i][j] = 'O';
            }
        }
    }

    /**
     * Go and find 0
     */
    public static void bfs(char[][] board, Queue<Integer> queue, int row, int col)
    {
        fill(board, queue, row, col);
        while (!queue.isEmpty()) // has more element to bfs search.
        {
            int number = queue.poll();
            row = number / board[0].length;
            col = number % board[0].length;
            fill(board, queue, row - 1, col);
            fill(board, queue, row + 1, col);
            fill(board, queue, row, col - 1);
            fill(board, queue, row, col + 1);
        }
    }

    // fill current position and push current position into queue, for later bfs action.
    public static void fill(char[][] board, Queue<Integer> queue, int row, int col)
    {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O')
            return;
        queue.offer(row * board[0].length + col);
        board[row][col] = 'P';
    }

    public static void main(String[] args)
    {
        String[] a =
                {"XOXOXO",
                 "OXOXOX",
                 "XOXOXO",
                 "OXOXOX"};
        char[][] board = new char[a.length][a[0].length()];
        for ( int i = 0; i < a.length; i++)
        {
            board[i] = a[i].toCharArray();
        }
        solve(board);
    }
}
