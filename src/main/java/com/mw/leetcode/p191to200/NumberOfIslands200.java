package com.mw.leetcode.p191to200;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200
{
    public static int numIslands(char[][] grid)
    {
        if (grid == null || grid.length ==0)
            return 0;

        int maxRow = grid.length;
        int maxCol = grid[0].length;
        // create a visit board.
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    bfs(grid, visited, i, j, queue);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(char[][] grid, boolean[][] visited, int row, int col, Queue<Integer> queue)
    {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || visited[row][col])
            return;

        visited[row][col] = true;

        if (row == 1 && col == 3)
        {
            visited[row][col] = true;
        }

        queue.offer(row * grid[0].length + col);

        while (!queue.isEmpty())
        {
            int number = queue.poll();
            row = number / grid[0].length;
            col = number % grid[0].length;
            bfs(grid, visited, row - 1, col, queue);
            bfs(grid, visited, row + 1, col, queue);
            bfs(grid, visited, row, col - 1, queue);
            bfs(grid, visited, row, col + 1, queue);
        }
    }

    public static void main(String[] args)
    {
        String[] a =
                {"11000",
                 "11010",
                 "10100",
                 "00010"};
        char[][] board = new char[a.length][a[0].length()];
        for ( int i = 0; i < a.length; i++)
        {
            board[i] = a[i].toCharArray();
        }
        System.out.println(numIslands(board));
    }
}
