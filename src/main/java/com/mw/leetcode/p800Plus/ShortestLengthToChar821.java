package com.mw.leetcode.p800Plus;

import com.mw.ProjectUtil;

public class ShortestLengthToChar821
{
    public int[] shortestToChar(String s, char C)
    {
        int n = s.length();
        int[] res = new int[s.length()];

        int pivot = -n;
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == C)
                pivot = i;
            res[i] = i - pivot;
        }

        for (int i = n - 1; i >= 0; i--)
        {
            if (s.charAt(i) == C)
                pivot = i;
            res[i] = Math.min(res[i], Math.abs(i - pivot));
        }

        return res;
    }

    public static void main(String[] args)
    {
        ShortestLengthToChar821 app = new ShortestLengthToChar821();
        int[] res = app.shortestToChar("loveleetcode", 'e');
        ProjectUtil.printIntArray(res);
    }
}
