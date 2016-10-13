package com.mw.leetcode.p341to350;

import com.mw.ProjectUtil;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays349
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) set2.add(num);

        Set<Integer> temp = new HashSet<>();
        for (Integer val : set1)
        {
            if (set2.contains(val))
                temp.add(val);
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
        IntersectionofTwoArrays349 app = new IntersectionofTwoArrays349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = app.intersection(nums1, nums2);
        ProjectUtil.printIntArray(result);
    }
}
