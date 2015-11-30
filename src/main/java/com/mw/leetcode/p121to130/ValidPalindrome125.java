package com.mw.leetcode.p121to130;

public class ValidPalindrome125
{
    public boolean isPalindrome(String s)
    {
        // skip non alphanumeric.
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--)
        {
            while (!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if (i <=j && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j)))
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(new ValidPalindrome125().isPalindrome("race a car"));
    }
}
