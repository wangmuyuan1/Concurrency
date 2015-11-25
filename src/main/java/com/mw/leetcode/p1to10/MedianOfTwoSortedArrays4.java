package com.mw.leetcode.p1to10;

public class MedianOfTwoSortedArrays4
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a;
        int[] b;

        //较短的放前面.
        if (nums1.length <= nums2.length)
        {
            a = nums1;
            b = nums2;
        }
        else
        {
            a = nums2;
            b = nums1;
        }

        // 计算几个关键Index的初值. min, max, mid
        int m = a.length;
        int n = b.length;
        int min = 0;
        int max = m;
        int mid = (m + n + 1) / 2; // make sure the left 至少和右边一样长。
        int n1 = 0;
        int n2 = 0;
        int i = (min + max) / 2;
        int j = mid - i;
        while (min <= max) // 我们需要逐渐narrow区间。
        {
            i = (min + max) / 2;
            j = mid - i;
            if (i < m && j > 0 && a[i] < b[j - 1]) // 说明我们需要把a右移，b左移
                min = i + 1;
            else if (j < n && i > 0 && b[j] < a[i - 1]) // 说明我们需要把a左移，b右移
                max = i - 1;
            else // 我们找到了这个i值了
            {
                if (i == 0) n1 = b[j - 1];
                else if (j == 0) n1 = a[i - 1];
                else n1 = Math.max(a[i - 1], b[j - 1]);
                break;
            }
        }

        if ((m + n) % 2 == 1)
            return n1;

        if (i == m) n2 = b[j];
        else if (j == n) n2 = a[i];
        else n2 = Math.min(a[i], b[j]);

        return ((double)n1 + (double)n2) / 2; // return double.
    }

    public static void main(String[] args)
    {
//        int[] nums1 = {4, 5, 6, 7};
//        int[] nums2 = {1, 2, 3};
//        System.out.println(findMedianSortedArrays(nums1, nums2) == 3.5);

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8, 9, 10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
