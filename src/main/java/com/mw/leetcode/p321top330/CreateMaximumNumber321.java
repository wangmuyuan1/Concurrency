package com.mw.leetcode.p321top330;

import com.mw.ProjectUtil;

import java.util.LinkedList;
import java.util.List;

public class CreateMaximumNumber321
{
    public int[] maxNumber(int[] nums1, int[] nums2, int k)
    {
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
        {
            int[] temp = merge(max(nums1, i), max(nums2, k - i));
            if (isGreater(temp, result))
                result = temp;
        }
        return result;
    }

    public boolean isGreater(int[] nums1, int[] nums2)
    {
        if (nums1.length < nums2.length)
            return false;

        if (nums1.length > 0 && nums2.length == 0)
            return true;

        for (int i = 0; i < nums2.length; i++)
        {
            if (nums1[i] > nums2[i])
                return true;
            if (nums1[i] < nums2[i])
                return false;
        }
        return false;
    }

    public int[] merge(int[] nums1, int[] nums2)
    {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length)
        {
            if (nums1[i] >= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        while (i < nums1.length)
            result[k++] = nums1[i++];
        while (j < nums2.length)
            result[k++] = nums2[j++];

        return result;
    }

    public int[] max(int[] nums, int n)
    {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (result.size() < n)
                result.add(nums[i]);
            else
            {
                // remove the one that less than the next.
                int idx = -1;
                for (int j = 0; j < result.size() - 1; j++)
                    if (result.get(j) < result.get(j + 1))
                        idx = j;

                if (idx >= 0)
                {
                    result.remove(idx);
                    result.add(nums[i]);
                }
                else if (!result.isEmpty() && nums[i] > result.get(result.size() - 1))
                    result.set(result.size() - 1, nums[i]);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            array[i] = result.get(i);
        return array;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {3, 9};
        int[] nums2 = {8, 9};

        int[] nums3 = {9,3,4,6,5,7};

        CreateMaximumNumber321 app = new CreateMaximumNumber321();

        ProjectUtil.printIntArray(app.maxNumber(nums1, nums2, 3));
    }
}
