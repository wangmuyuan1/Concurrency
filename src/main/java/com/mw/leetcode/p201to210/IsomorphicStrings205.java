package com.mw.leetcode.p201to210;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205
{
    public boolean isIsomorphic(String s, String t)
    {
        // Build a hashtable to store char
        if ((s == null && t != null) || (s != null && t == null))
            return false;
        if (s == null && t == null)
            return true;
        return s.length() == t.length() && convert(s).equals(convert(t));
    }

    public String convert(String s)
    {
        char l = 'A';
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!map.containsKey(c))
            {
                sb.append(l);
                map.put(c, l);
                l++;
            }
            else
            {
                sb.append(map.get(c));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new IsomorphicStrings205().isIsomorphic("paper", "title"));
    }
}
