package com.mw.leetcode.p11to20;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17
{
    public static List<String> letterCombinations(String digits)
    {
        String[] array = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits.length() > 0)
        {
            int cur = Integer.parseInt(digits.charAt(0) + "");
            List<String> p = letterCombinations(digits.substring(1));
            for (char c : array[cur].toCharArray())
            {
                if (!p.isEmpty())
                {
                    for (String s : letterCombinations(digits.substring(1)))
                    {
                        result.add(c + s);
                    }
                }
                else
                {
                    result.add(c + "");
                }
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        letterCombinations("234").forEach( x ->System.out.print(x + " "));
    }
}
