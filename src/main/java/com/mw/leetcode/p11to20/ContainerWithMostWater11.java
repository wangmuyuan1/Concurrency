package com.mw.leetcode.p11to20;

public class ContainerWithMostWater11
{
    public static int maxArea(int[] height)
    {
        if (height.length < 2)
            return 0;

        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;)
        {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args)
    {
        int[] heights = {10, 20, 51, 18, 4, 23, 77};
        System.out.println(maxArea(heights));
    }
}
