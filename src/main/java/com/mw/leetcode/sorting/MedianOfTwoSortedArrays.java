package com.mw.leetcode.sorting;

public class MedianOfTwoSortedArrays
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] array = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length&& j < nums2.length)
        {
            if (nums1[i] < nums2[j])
            {
                array[k] = nums1[i];
                i++;
            }
            else
            {
                array[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (i < nums1.length)
        {
            for (; i < nums1.length; i++)
            {
                array[k] = nums1[i];
                k++;
            }
        }

        if (j < nums2.length)
        {
            for (; j < nums2.length; j++)
            {
                array[k] = nums2[j];
                k++;
            }
        }

        double median;
        if (array.length % 2 == 0)
        {
            median = (array[array.length / 2 - 1] + (double)array[array.length / 2]) / 2;
        }
        else
        {
            median = array[array.length / 2];
        }
        return median;
    }

    public static void main(String[] args)
    {
        //int[] nums1 = {2, 2, 3, 4, 5};
        //int[] nums2 = {11, 12, 12, 12, 13};

        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
