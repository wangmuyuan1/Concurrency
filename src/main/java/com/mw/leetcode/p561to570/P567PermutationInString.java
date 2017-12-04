package com.mw.leetcode.p561to570;

import java.util.Arrays;

public class P567PermutationInString
{
    public boolean checkInclusion(String s1, String s2)
    {
        int[] map = new int[26];
        int[] copyMap = new int[26];
        int[] firstLoc = new int[26];

        Arrays.fill(firstLoc, -1);

        if (s2.length() < s1.length())
            return false;

        if (s1.length() == 0 && s2.length() == 0)
            return true;

        char[] array = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++)
        {
            map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < map.length; i++)
        {
            if (map[i] == 0)
                map[i] = -1;
            copyMap[i] = map[i];
        }

        int start = 0;
        int length = 0;
        for (int i = 0; i < array.length; i++)
        {
            // if a char not in map, then jump to next char.
            if (map[array[i] - 'a'] == -1)
            {
                length = 0;
                start = i + 1;
                restore(map, copyMap);
            }
            // if a char in map is already zero, jump to the first appearance of the char.
            else if (map[array[i] - 'a'] == 0)
            {
                i = firstLoc[array[i] - 'a'];
                length = Math.max(0, length - (i - start + 1));
                for (int j = start; j <= i; j++)
                {
                    map[array[j] - 'a']++;
                    if (map[array[j] - 'a'] == copyMap[array[j] - 'a'])
                        firstLoc[array[i] - 'a'] = -1;
                }
            }
            else
            {
                length++;
                if (map[array[i] - 'a'] > 0)
                    map[array[i] - 'a']--;

                if (length == s1.length())
                    return true;

                if (firstLoc[array[i] - 'a'] == -1)
                    firstLoc[array[i] - 'a'] = i;
            }


        }
        return false;
    }

    private void restore(int[] m1, int[] m2)
    {
        for (int i = 0; i < m1.length; i++)
            m1[i] = m2[i];
    }

    public static void main(String[] args)
    {
        P567PermutationInString app = new P567PermutationInString();
        System.out.println(app.checkInclusion("adc", "dcda"));
    }
}
