package com.mw.leetcode.p51to60;

public class JumpGame55
{
    public static boolean canJump(int[] nums)
    {
        int reach = 0;
        for (int i = 0; i <= reach && i < nums.length; i++)
        {
            reach = Math.max(reach, i + nums[i]);
        }

        return reach >= nums.length - 1;
    }

    public static void main(String[] args)
    {
        int[] array = {0, 1};
        System.out.println(canJump(array));
    }
}
