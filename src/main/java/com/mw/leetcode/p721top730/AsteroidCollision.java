package com.mw.leetcode.p721top730;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision
{
    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> res = new ArrayList<>();

        // go from left to right to see -> if array.
        // go from right to left ->
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++)
        {
            if (asteroids[i] > 0)
                stack.push(i);
            else if (asteroids[i] < 0)
            {
                while (asteroids[i] < 0 && !stack.isEmpty())
                {
                    int idx = stack.pop();
                    if (Math.abs(asteroids[i]) > Math.abs(asteroids[idx]))
                        asteroids[idx] = 0;
                    else if (Math.abs(asteroids[i]) < Math.abs(asteroids[idx]))
                    {
                        asteroids[i] = 0;
                        stack.push(idx);
                    }
                    else
                    {
                        asteroids[idx] = 0;
                        asteroids[i] = 0;
                    }
                }
            }
        }

        for (int asteroid : asteroids)
        {
            if (asteroid != 0)
            {
                res.add(asteroid);
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        return ret;
    }

    public static void main(String[] args)
    {
        AsteroidCollision app = new AsteroidCollision();
        int[] asteroids = {-2,2,-1,-2};
        ProjectUtil.printIntArray(app.asteroidCollision(asteroids));
    }
}
