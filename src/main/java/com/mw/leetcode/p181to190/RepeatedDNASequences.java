package com.mw.leetcode.p181to190;

import java.util.*;

public class RepeatedDNASequences
{
    public List<String> findRepeatedDnaSequences(String s)
    {
        Set<Integer> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        for (int i = 0; i < s.length() - 9; i++)
        {
            int v = 0;
            for (int j = i; j < i + 10; j++)
            {
                v |= map.get(s.charAt(j));
                v <<= 2;
            }

            if (visited.contains(v))
            {
                result.add(s.substring(i, i + 10));
            }
            else
            {
                visited.add(v);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args)
    {
        /**
         * Idea, there are only four chars 'A' 'C' 'G' 'T', we can convert the char based string to binary int.
         * How? we can create a map, where map A = 0, map C = 1 map G = 2 map T =3.
         * For each char in the char, we go 10 step from that char. and check if we already have that string in the set.
         * The key is to minimize the String
         */
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s1));
    }
}
