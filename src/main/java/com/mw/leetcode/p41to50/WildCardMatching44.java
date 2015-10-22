package com.mw.leetcode.p41to50;

public class WildCardMatching44
{
    public static boolean isMatch(String s, String p)
    {
        int i = 0; // point to start of s.
        int j = 0; // point to start of p.
        int star = -1; // point to star position
        int mark = -1;
        while (i < s.length())
        {
            // match the char. or the char is any.
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)))
            {
                i++; j++;
            }
            // match the *, set start = j, set mark = i, j++
            else if (j < p.length() && p.charAt(j) == '*')
            {
                star = j;
                j++;
                mark = i;
            }
            else if (star != -1)
            {
                j = star + 1; // always point the char after *. even it match once, it can still go back.
                mark++;
                i = mark;
            }
            else
            {
                return false;
            }
            // not match.
        }

        // skip util next char.
        while (j < p.length() && p.charAt(j) == '*')
        {
            j++;
        }

        return j == p.length();
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("abacbab", "a*ab*"));
    }
}