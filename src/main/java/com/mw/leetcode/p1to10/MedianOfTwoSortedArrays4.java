package com.mw.leetcode.p1to10;

public class MedianOfTwoSortedArrays4
{
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // if m + n is odd, then we need only return the kth where for this moment k = m + n / 2
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even case, then we return ((k - 1)th + kth) /2
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) // k = m + n / 2
                + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5; // (k - 1)th
        }
    }

    public static int findKth(int A[], int B[], int k,
        int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart]; // if k == 0 return the lesser from the two start.

        int aMid = aLen * k / (aLen + bLen); // a's middle count. k / (aLen + bLen) can cal the kth element from the two array.
        int bMid = k - aMid - 1; // b's middle count because k is cal from aLen + bLen, but k - aMid - 1 should be the index of bMid

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
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
