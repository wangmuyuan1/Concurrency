package com.mw.leetcode.p251to260;

public class SingleNumberIII260
{
    public int[] singleNumber(int[] nums)
    {
        int[] result = new int[2];

        int diff = 0;
        for (int num : nums)
            diff ^= num;

        // How to get the different digit? we just need to check the
        diff &= -diff; // this will give the last 1 in binary.

        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
                result[0] ^= num;
            else // the bit is set
                result[1] ^= num;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(-3));
    }
}
