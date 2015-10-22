package com.mw.leetcode.p41to50;

public class TrappingRainWater42
{
    public static int trap(int[] height)
    {
        // to hold water.
        // 1. both left and right hand side has to higher than current.
        // 2. if current right hand side is lower.
        //    then we move forward to see if it is possible to find another boundary that is higher than current.
        //    if we find. then current one can hold
        //    else. current cannot hold.
        // The approach would be cal the highest from the left for each i. and cal the highest right from end.
        // and then min(left, right) - current, which means, no matter what bars exists between cur and right, the cur can hold x amount water.

        int result = 0;
        if (height.length <= 2)
            return result;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0]; // left most.
        right[height.length - 1] = height[height.length - 1]; // right most.

        for (int i = 1; i < height.length; i++)
        {
            //when calculate the left, if highest left is cur. then cur cannot hold any water. no matter how high the right bar is.
            left[i] = Math.max(height[i], left[i - 1]);

            //when calculate from the right, if the height right bar is cur, then cur cannot hold any water, no matter how high the left bar is.
            right[height.length - 1 - i] = Math.max(height[height.length - 1 - i], right[height.length - i]);
        }

        for (int i = 1; i < height.length; i++)
        {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] height = {4,9,4,5,3,2};
        System.out.println(trap(height));
    }
}
