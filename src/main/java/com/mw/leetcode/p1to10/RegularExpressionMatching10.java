package com.mw.leetcode.p1to10;

public class RegularExpressionMatching10
{
    public static boolean isMatch(String s, String p)
    {
        if (p.length() ==0) return s.length() == 0;

        if (p.length() == 1 || p.charAt(1) != '*' )
        {
            if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
            {
                return false;
            }

            return isMatch(s.substring(1), p.substring(1));
        }

        else
        {
            int i = -1;
            while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i)))
            {
                if (isMatch(s.substring(i + 1), p.substring(2))) // we have to make sure 0 is going to be matched without pre any condition.
                                                                    // Once it is matched, we return .
                {
                    return true;
                }
                i++;
            }

            return false;
        }
    }

    public static void main(String[] args)
    {
        /**
         * isMatch("aa","a") → false
         isMatch("aa","aa") → true
         isMatch("aaa","aa") → false
         isMatch("aa", "a*") → true
         isMatch("aa", ".*") → true
         isMatch("ab", ".*") → true
         isMatch("aab", "c*a*b") → true
         */
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("aaa", "aa"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aa", "d.*"));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("aaa", "..a"));
//        System.out.println(isMatch("aaa", "a*aaa"));
//        System.out.println(isMatch("aaa", "ab*ac*a"));
//        System.out.println(isMatch("aaa", ".*..c*"));
//        System.out.println(isMatch("ab", ".*..c*"));
          System.out.println(isMatch("", ".*"));
    }
}
