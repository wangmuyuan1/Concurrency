package com.mw.leetcode.p221top230;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwang on 01/05/2016.
 */
public class MajorityElementII229
{
    public List<Integer> majorityElement(int[] nums)
    {
        Integer can1 = null, can2 = null, c1 = 1, c2 = 1;
        for (int i = 0; i < nums.length; i++)
        {
            if (can1 == null) can1 = nums[i];
            else if (nums[i] != can1 && can2 == null) can2 = nums[i];
            else if (nums[i] == can1) c1++;
            else if (nums[i] == can2) c2++;
            else if (c1 == 0) {can1 = nums[i]; c1 = 1;}
            else if (c2 == 0) {can2 = nums[i]; c2 = 1;}
            else
            {c1--; c2--;}
        }

        c1 = 0;
        c2 = 0;
        for (int num : nums)
        {
            if (num == can1) c1++;
            if (can2 != null && num == can2) c2++;
        }

        List<Integer> result = new ArrayList<>();
        if (c1 > nums.length / 3) result.add(can1);
        if (c2 > nums.length / 3) result.add(can2);

        return result;
    }
}
