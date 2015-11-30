package com.mw.leetcode.p131to140;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131
{
    public List<List<String>> partition(String s)
    {
        List<List<String>>[] result = new ArrayList[s.length() + 1]; // result[i] means result to index i;
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());

        //创建dp矩阵
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            result[i + 1] = new ArrayList<>();
            for (int j = i; j >= 0; j--)
            {
                // 判断j to i 是否为palindrome.
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1]))
                {
                    dp[j][i] = true;
                    String str = s.substring(j, i + 1); // 创建palindrome.
                    for (List<String> r : result[j]) // for each result in result[j] (result up to j). we append the str and add them as new result to i + 1.
                    {
                        List<String> ri = new ArrayList<>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[s.length()];
    }
}
