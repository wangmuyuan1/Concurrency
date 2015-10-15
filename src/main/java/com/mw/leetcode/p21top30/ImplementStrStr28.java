package com.mw.leetcode.p21top30;

public class ImplementStrStr28
{
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        else if (haystack.length() == 0)
        {
            return -1;
        }

        int sLen = haystack.length();
        int pLen = needle.length();
        int next[] = buildNext(needle);
        int i = 0, j = 0;
        while (i < sLen && j < pLen)
        {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    public static int[] buildNext(String needle)
    {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int t = -1; // t means prefix index.
        int i = 0; // i means postfix index.

        while (i < needle.length() - 1)
        {
            if (t < 0
                    ||
                    needle.charAt(i) == needle.charAt(t)// if p[i] == p[t] means the prefix and post fix matches.
                    )
            {
                // if t < 0 or prefix and post fix matches we increase the index in both prefix and postfix to next index.
                i++;
                t++;

                next[i] = (needle.charAt(i) != needle.charAt(t)) // if the prefix and post fix still matches. the next[i] = next[t] copy from the previous value. else mark next[i] with t,
                        ? t : next[t];
            }
            else //the prefix and post fix doesnt match. we should move t back to the last value of the match, else to the begining of array.
            {
                t = next[t];
            }
        }
        return next;
    }

    public static void main(String[] args)
    {
        int[] next = buildNext("abcdabd");
        for (int i : next)
        {
            System.out.println(i);
        }
    }
}
