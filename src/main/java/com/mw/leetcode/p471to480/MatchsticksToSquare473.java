package com.mw.leetcode.p471to480;

import java.util.Arrays;

public class MatchsticksToSquare473
{
    public boolean makesquare(int[] nums) {
        long sum = 0;
        for (int num : nums)
            sum += num;

        if (sum == 0 || sum % 4 != 0) return false;

        long edge = sum / 4;
        // dfs

        Arrays.sort(nums);
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        long sum4 = 0;
        boolean res = dfs(nums, nums.length - 1, sum1, sum2, sum3, sum4, edge);
        if (!res)
            return false;
        return true;
    }

    public boolean dfs(int[] nums, int cur, long sum1, long sum2, long sum3, long sum4, long width)
    {
        if (sum1 > width || sum2 > width || sum3 > width || sum4 > width)
            return false;

        if (cur == -1)
        {
            return sum1 == width && sum2 == width && sum3 == width && sum4 == width;
        }

        return dfs(nums, cur - 1, sum1 + nums[cur], sum2, sum3, sum4, width) ||
                dfs(nums, cur - 1, sum1, sum2 + nums[cur], sum3, sum4, width) ||
                dfs(nums, cur - 1, sum1, sum2, sum3 + nums[cur], sum4, width) ||
                dfs(nums, cur - 1, sum1, sum2, sum3, sum4 + nums[cur], width);
    }

    public static void main(String[] args)
    {
        int[] array = {5,5,5,5,4,4,4,4,3,3,3,3};
        MatchsticksToSquare473 app = new MatchsticksToSquare473();
        System.out.println(app.makesquare(array));
    }
}
