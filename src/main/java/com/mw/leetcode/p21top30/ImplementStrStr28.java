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
                j = next[j]; // if the next j is -1, then we move both i and j (in next loop)
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
        int pre = -1; // t means prefix index.
        int post = 0; // i means postfix index.

        while (post < needle.length() - 1)
        {
            if (pre < 0
                    ||
                    needle.charAt(post) == needle.charAt(pre)// if p[i] == p[t] means the prefix and post fix matches.
                    )
            {
                // if t < 0 or prefix and post fix matches we increase the index in both prefix and postfix to next index.
                pre++;
                post++;

                next[post] = (needle.charAt(post) != needle.charAt(pre)) // if the prefix and post fix still matches. the next[i] = next[t] copy from the previous value. else mark next[i] with t,
                        ? pre : next[pre];
            }
            else //the prefix and post fix doesnt match. we should move t back to the last value of the match, else to the begining of array.
            {
                pre = next[pre];
            }
        }
        return next;
    }

    public static int strStrYT(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        else if (haystack.length() == 0)
        {
            return -1;
        }
        int[] next = buildNextYT(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length())
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if (j == needle.length())
                {
                    return i - j;
                }
            }
            else
            {
                if (j > 0)
                    j = next[j - 1];
                else
                {
                    j = 0;
                    while (i < haystack.length() && haystack.charAt(i) != needle.charAt(j))
                        i++;
                }
            }
        }

        return -1;
    }

    public static int[] buildNextYT(String needle)
    {
        char[] array = needle.toCharArray();
        int[] next = new int[needle.length()];

        if (needle.length() <= 1) return next;
        int i = 1;
        int j = 0;

        while (i < needle.length())
        {
            if (array[i] != array[j])
            {
                if (j > 0) j = next[j - 1];
                else
                {
                    next[i] = 0;
                    i++;
                }
            }
            else
            {
                next[i] = j + 1;
                i++;
                j++;
            }
        }
        return next;
    }

    public static void main(String[] args)
    {
//        int[] next = buildNextYT("abcdabca");
//        Arrays.stream(next).forEach(System.out::print);
//        System.out.println();
//        next = buildNextYT("aabaabaaa");
//        Arrays.stream(next).forEach(System.out::print);
//        System.out.println();
//
//        next = buildNextYT("abcaby");
//        Arrays.stream(next).forEach(System.out::print);
//        System.out.println();


        System.out.println(strStrYT("aabaaabaaac", "aabaaac"));
    }
}
