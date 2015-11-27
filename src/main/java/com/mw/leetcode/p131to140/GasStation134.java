package com.mw.leetcode.p131to140;

public class GasStation134
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int start = 0;
        int deficit = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++)
        {
            tank += gas[i] - cost[i];
            if (tank < 0)
            {
                start = i + 1;
                deficit += tank; // record the deficit.
                tank = 0;
            }
        }

        return deficit + tank < 0 ? -1 : start;
    }
}
