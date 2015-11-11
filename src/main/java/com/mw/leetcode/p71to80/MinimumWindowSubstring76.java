package com.mw.leetcode.p71to80;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76
{
    public static String minWindow(String s, String t)
    {
        // maintain a window for all
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            if (targetMap.keySet().contains(c))
            {
                targetMap.put(c, targetMap.get(c) + 1);
            }
            else
            {
                targetMap.put(c, 1);
            }
        }

        Map<Character, Integer> curMap = new HashMap<>();

        // check if map is empty.
        int count = 0;
        int left = -1;
        int minLen = s.length() + 1;
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (targetMap.keySet().contains(c))
            {
                if (curMap.containsKey(c))
                {
                    if (curMap.get(c) < targetMap.get(c))
                    {
                        count++;
                    }
                    curMap.put(c, curMap.get(c) + 1);
                }
                else
                {
                    if (left == -1)
                        left = i;
                    curMap.put(c, 1);
                    count++;
                }
            }

            if (count == t.length())
            {
                char sc = s.charAt(left);
                // IMPORTANT, the first condition is !curMap.containsKey(sc) because we always move left,
                // so the map may not contains the key. the loop doesnt quit until we hit last char that should be in the map and its count matches.
                // the second condition means the loop doesn't exit until cur.getkey < target.getkey.
                while (!curMap.containsKey(sc) || curMap.get(sc) > targetMap.get(sc))
                {
                    if (curMap.containsKey(sc) && curMap.get(sc) > targetMap.get(sc))
                        curMap.put(sc, curMap.get(sc) - 1);
                    left++;
                    sc = s.charAt(left);
                }

                if (i - left + 1 < minLen)
                {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        String s = "bdab";
        String t = "ab";

        System.out.println(minWindow(s, t));
    }
}
