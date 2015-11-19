package com.mw.leetcode.p141to150;

import com.mw.leetcode.Point;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine149
{
    public static int maxPoints(Point[] points)
    {
        if(points == null || points.length == 0)
            return 0;

        if(points.length == 1)
            return 1;

        Map<Double, Integer> map = new HashMap<>(); // Slope and max number of nodes on that slope.
        int max = 0;
        for (int i = 0; i < points.length; i++)
        {
            int same = 1; // at least one same.
            int vertical = 0;
            for (int j = 0; j < points.length; j++)
            {
                if (i == j)
                    continue;

                if (points[i].x == points[j].x)
                {
                    if(points[i].y == points[j].y){
                        same++;
                    } else{
                        vertical++;
                    }
                }
                else
                {
                    double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    if (map.containsKey(slope))
                    {
                        map.put(slope, map.get(slope) + 1);
                    }
                    else
                    {
                        map.put(slope, 1);
                    }
                }
            }

            for (int count: map.values())
            {
                max = Math.max(max, count + same);
            }
            max = Math.max(max, vertical + same);
            map.clear();
        }

        return max;
    }

    public static void main(String[] args)
    {

    }
}
