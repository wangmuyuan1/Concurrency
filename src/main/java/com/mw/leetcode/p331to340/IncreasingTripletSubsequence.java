package com.mw.leetcode.p331to340;

/**
 * Created by mwang on 06/04/2016.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {

        if (nums.length == 0)
            return false;
        int min = Integer.MAX_VALUE; int max = Integer.MAX_VALUE;

        for (int num : nums)
        {
            if (num <= min) min = num; // in first run the min will be nums[0] but max is unset.
            else if (num <= max) max = num;
            else return true; // the third num greater than min and max.
        }

        return false;
    }

    public static void main(String args[])
    {
        IncreasingTripletSubsequence subsequence = new IncreasingTripletSubsequence();

        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println(subsequence.increasingTriplet(array1));

        int[] array2 = {5, 4, 3, 2, 1};
        System.out.println(subsequence.increasingTriplet(array2));
    }
}
