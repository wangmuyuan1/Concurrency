package com.mw.leetcode.p111to120;

import java.util.ArrayList;
import java.util.List;

public class DistinctSubsequences115
{
    public static int numDistinct(String s, String t)
    {
        //Let W(i, j) stand for the number of subsequences of S(0, i) equals to T(0, j).
        // If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j); Otherwise, W(i, j) = W(i-1,j).
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // eg. s = "rabbit" t = "rs" if i = 2, and j = 1, then r is definitely the sub of ra,
        //     s = "rabbit" t = "ra" if i = 2 and j = 2 then since when i = 1 and j = 1, r is the substring of r and i = 2 and j = 1,
        // r is substring of ra, so i, j = the matching number of s(0, i - 1) matches to t(0, j) // at least
                                          // (cause if s(0, i -1) matched to t(0,j), then even s(i) doesnt match, dp[i][j] is at least dp[i - 1][j]
                                         // + if s.charAt(i - 1) == t.charAt(j - 1) the number of s(0, i - 1) matches to t(0, j - 1)
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1; // because for any given empty t, s(0, i) at least has 1 matching

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 1; j <= t.length(); j++)
            {
                dp[i][j] = dp[i - 1][j] + (s.charAt(i - 1) == t.charAt(j - 1) ? dp[i-1][j-1] : 0);
            }
        }

        return dp[s.length()][t.length()];
    }

    public static int numDistinct1(String s, String t)
    {
        List<Integer> count = new ArrayList<>();
        count.add(0);
        dfs(0, 0, s, t, new StringBuilder(), count);
        return count.get(0);
    }

    private static void dfs(int ss, int st, String s, String t, StringBuilder cur, List<Integer> count)
    {
        if (st >= t.length())
        {
            count.set(0, count.get(0) + 1);
            return;
        }
        if (ss >= s.length())
            return;

        for (int i = ss; i < s.length(); i++)
        {
            if (s.charAt(i) == t.charAt(st))
            {
                cur.append(s.charAt(i));
                dfs(i + 1, st + 1, s, t, cur, count);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println(numDistinct("ccc", "c"));
    }
}
