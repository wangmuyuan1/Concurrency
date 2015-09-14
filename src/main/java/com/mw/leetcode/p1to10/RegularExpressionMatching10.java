package com.mw.leetcode.p1to10;

public class RegularExpressionMatching10
{
    public static boolean isMatch1(String s, String p)
    {
        // for any input, if p.length is 0, s must be 0
        if (p.length() == 0)
            return s.length() == 0;

        // for last char in p, we will never let * to be the last char as we always skip .* all together.
        if (p.length() == 1)
        {
            // if the length of s is zero
            if (s.length() < 1)
            {
                return false;
            }
            else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') // if p is not .
            {
                return false;
            }
            else // this char matches. but s could potentially has more char.
            {
                return isMatch1(s.substring(1), p.substring(1));
            }
        }

        if (p.charAt(1) != '*') // not a* or .*
        {
            if (s.length() <= 1)
            {
                return false;
            }
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
            {
                return false;
            }
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        else // a* or .*
        {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    public static boolean isMatch(String s, String p)
    {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // special case
        if (p.length() == 1) {

            // if the length of s is 0, return false
            if (s.length() < 1) {
                return false;
            }

            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s.substring(i + 1), p.substring(2))) {
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
