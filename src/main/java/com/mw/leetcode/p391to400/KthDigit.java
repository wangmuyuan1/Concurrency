package com.mw.leetcode.p391to400;

/**
 * Created by mwang on 20/10/2016.
 */
public class KthDigit
{
    static class Solution
    {
        public int findNthDigit(int n) {
            int len = 1;
            long count = 9;
            int start = 1;
            while (n > len * count)
            {
                n -= len * count;
                len++;
                count *= 10;
                start *= 10;
            }

            start += (n - 1) / len; // find which element.
            String s = Integer.toString(start);
            // find which digit. in the element.
            int digit = (n - 1) % len;
            return Character.getNumericValue(s.charAt(digit));
        }
    }
}
