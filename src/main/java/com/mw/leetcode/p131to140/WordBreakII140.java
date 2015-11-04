package com.mw.leetcode.p131to140;

import java.util.*;

public class WordBreakII140
{
    public static List<String> wordBreak(String s, Set<String> wordDict)
    {
        List<String> result = new ArrayList<>(); // store result.
        List<String> temp = new ArrayList<>(); // stack hold temp result while doing dfs.
        List<String>[] array = new List[s.length() + 1]; // for each cell of the array, it stores the words that can reach current index.
        array[0] = new ArrayList<>(); // IMPORTANT, we need init array[0] otherwise it will be skipped in the loop.

        for (int i = 0; i < s.length(); i++)
        {
            if( array[i] == null ) // this is important as we need skip as much as possible.
                continue;

            for (String word : wordDict)
            {
                int end = i + word.length();
                if (end <= s.length() && s.substring(i, end).equals(word))
                {
                    if (array[end] == null)
                    {
                        array[end] = new ArrayList<>();
                    }
                    array[end].add(word);
                }
            }
        }

        if (array[s.length()] == null || array[s.length()].isEmpty())
            return result;

        dfs(array, s.length(), result, temp);

        return result;
    }

    // This method do dfs from the last index of the array and try to reach the first index.
    private static void dfs(List<String>[] array, int lastIndex, List<String> result, List<String> temp)
    {
        if (lastIndex <= 0)
        {
            // Add all temp into result.
            StringBuilder sb = new StringBuilder();
            for (int i = temp.size() - 1; i >= 1; i--)
            {
                sb.append(temp.get(i) + " ");
            }
            sb.append(temp.get(0));
            result.add(sb.toString());
            return;
        }

        for (String s : array[lastIndex])
        {
            temp.add(s);
            dfs (array, lastIndex - s.length(), result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        HashSet<String> wordDict = new HashSet<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        for (String s : wordBreak("catsanddog", wordDict))
        {
            System.out.println(s);
        }
//        wordDict.add("a");
//        for (String s : wordBreak("a", wordDict))
//        {
//            System.out.println(s);
//        }
    }
}
