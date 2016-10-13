package com.mw.leetcode.p341to350;

import com.mw.ProjectUtil;

import java.util.*;

public class IntersectionofTwoArraysII350
{
    public int[] interset(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1)
        {
            if (map1.containsKey(num))
                map1.put(num, map1.get(num) + 1);
            else
                map1.put(num, 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2)
        {
            if (map2.containsKey(num))
                map2.put(num, map2.get(num) + 1);
            else
                map2.put(num, 1);
        }

        List<Integer> temp = new ArrayList<>();
        for (Integer val : map1.keySet())
        {
            if (map2.containsKey(val))
            {
                int times1 = map1.get(val);
                int times2 = map2.get(val);
                int times = Math.min(times1, times2);

                for (int i = 0; i < times; i++)
                {
                    temp.add(val);
                }
            }
        }

        int[] result = new int[temp.size()];
        int i = 0;
        for (Integer val : temp)
        {
            result[i++] = val;
        }
        return result;
    }

    public static void main(String[] args)
    {
        IntersectionofTwoArraysII350 app = new IntersectionofTwoArraysII350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = app.interset(nums1, nums2);
        ProjectUtil.printIntArray(result);
    }
}
