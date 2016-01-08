package com.mw.leetcode.p231to240;

public class PowerOfTwo231
{
    public boolean isPowerOfTwo(int n)
    {
        return n > 0 && (n & n -1) == 0;
    }
}
