package com.mw.leetcode.p781to790;

import java.util.*;

public class CheapestFlightsWithinKStops
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[][][] dp = new int[n][n][2];

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        for (int[][] dp1 : dp)
            for (int[] dp2 : dp1)
                Arrays.fill(dp2, -1);

        for (int[] route : flights)
        {
            if (route[0] == src)
            {
                if (!seen.contains(route[1]))
                {
                    queue.offer(route[1]);
                    seen.add(route[1]);
                }
                dp[route[0]][route[1]][0] = 0;
            }
            dp[route[0]][route[1]][0] = 0;
            dp[route[0]][route[1]][1] = route[2];
        }

        int stop = 0;
        if(K == 0){
            return dp[src][dst][0] == -1? -1 : dp[src][dst][1];
        }
        while (!queue.isEmpty())
        {
            if (stop > K) break;

            int sz = queue.size();
            seen = new HashSet<>();
            for (int i = 0; i < sz; i++)
            {
                int cur = queue.poll();

                for (int[] route: flights)
                {
                    if (route[0] == cur)
                    {
                        if (!seen.contains(route[1]))
                        {
                            queue.offer(route[1]);
                            seen.add(route[1]);
                        }
                        dp[src][route[1]][0] = stop;
                        dp[src][route[1]][1] = dp[src][route[1]][1] == -1 ? dp[src][route[0]][1] + route[2] : Math.min(dp[src][route[0]][1] + route[2], dp[src][route[1]][1]);
                    }
                }
            }
            stop++;
        }

        return dp[src][dst][0] == -1? -1 : dp[src][dst][1];
    }

    public static void main(String[] args)
    {
        CheapestFlightsWithinKStops app = new CheapestFlightsWithinKStops();
//        int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//        System.out.println(app.findCheapestPrice(5, flights, 2, 1, 1));
//        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int[][] flights = {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
        System.out.println(app.findCheapestPrice(5, flights, 0, 4, 1));
    }
}
