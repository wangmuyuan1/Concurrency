package com.mw.leetcode.p241to250;

public class ValidAnagram242
{
    public boolean isAnagram(String s, String t)
    {
        int[] array = new int[26];
        for (char c : s.toCharArray())
            array[c - 'a']++;
        for (char c : t.toCharArray())
            array[c - 'a']--;

        for (int a : array)
            if (a != 0)
                return false;
        return true;
    }
}
