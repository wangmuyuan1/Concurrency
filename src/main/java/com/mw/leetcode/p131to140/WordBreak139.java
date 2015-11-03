package com.mw.leetcode.p131to140;

import java.util.Set;

public class WordBreak139
{
    public boolean wordBreak(String s, Set<String> wordDict)
    {
        boolean[] array = new boolean[s.length() + 1];

        array[0] = true; // THIS IS KEY, because you need match from 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (!array[i]) // if array[4] and array[5] both true, we should start from array[4].
                continue;
            for (String word : wordDict)
            {
                int end = i + word.length();
                if (end > s.length())
                    continue;
                if (array[end]) // for example length 4 is matching, we should also consider length 5.
                    continue;
                if (s.substring(i, end).equals(word))
                    array[end] = true;
            }
        }

        return array[s.length()];
    }
}
