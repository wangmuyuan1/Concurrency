package com.mw.leetcode.p171to180;

public class DungeonGame174
{
    public static int calculateMinimumHP(int[][] dungeon)
    {
        if (dungeon.length == 0 || dungeon[0].length == 0)
        {
            return 1;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] min = new int[m][n]; // stores min health required for the room
        // calculate from the bottom will be easier. as you can recursively determine the required value.
        min[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1); // if dungeon is positive, the required value before entering the room is 1.
                                                                    // 1 - dungeon[m - 1][n - 1] means it has to leave 1 point health.

        // cal the last col.
        for (int i = m - 2; i >= 0; i--)
        {
            min[i][n - 1] = Math.max(min[i + 1][n - 1] - dungeon[i][n - 1], 1); //i + 1, n - 1 is the cell under this cell. if current cell has a lot heal. then the required. health for prev step is 1.
        }

        for (int j = n - 2; j >= 0; j--)
        {
            min[m - 1][j] = Math.max(min[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                int down = Math.max(min[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(min[i][j + 1] - dungeon[i][j], 1);
                min[i][j] = Math.min(down, right);
            }
        }

        return min[0][0];
    }

    public static void main(String[] args)
    {
        int[][] board = {{0, -3}};
        System.out.println(calculateMinimumHP(board));
    }
}
