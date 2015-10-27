package com.mw.leetcode.p41to50;

import java.util.*;

public class GroupAnagrams49
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs)
        {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);
            if (map.containsKey(newStr))
            {
                map.get(newStr).add(s);
                map.get(newStr).sort(new Comparator<String>()
                {
                    @Override
                    public int compare(String o1, String o2)
                    {
                        return o1.compareTo(o2);
                    }
                });
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newStr, list);
            }
        }

        for (String k : map.keySet())
        {
            result.add(map.get(k));
        }

        return result;
    }

    public static void main(String[] args)
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result)
        {
            for (String s : list)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
