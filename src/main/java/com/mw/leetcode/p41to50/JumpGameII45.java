package com.mw.leetcode.p41to50;

public class JumpGameII45
{
    public static int jump(int[] nums)
    {
        int reach = 0;
        int step = 0;
        int lastReach = 0; // a index tries the furthest reach to current index which is smaller than the reach.

        // we increase step by 1 and also keep tracking the reach to the current index.
        for (int i = 0; i <= reach && i < nums.length; i++)
        {
            if (lastReach < i) // last Reach cannot get to the index i.
            {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, i + nums[i]); // the furthest can go.
        }
        // after exit from the loop. the reach is the furthest can go from the start.


        if (reach < nums.length - 1)
            return 0;

        return step;
    }

    public static void main(String[] args)
    {
        int[] array = {2,1};
        System.out.println(jump(array));
    }
}
