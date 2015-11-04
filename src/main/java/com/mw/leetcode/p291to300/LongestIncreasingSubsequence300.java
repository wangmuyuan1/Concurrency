package com.mw.leetcode.p291to300;

public class LongestIncreasingSubsequence300
{
    public static int lengthOfLIS(int[] nums)
    {
        // declare a max array to store max reach from current index;
        int[] max = new int[nums.length];

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++)
        {
            max[i] = 1; // each index has max value at least 1.
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i]) // if j which is before i is less than i and previous j can reach
                {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            if (max[i] > maxLen)
                maxLen = max[i];
        }

        return maxLen;
    }

    public static int lengthOfLIS11(int[] nums)
    {
        int[] L = new int[nums.length]; // max number of step it can extend.
        L[0] = 1;
        for(int i = 1;i < L.length; i++){
          int maxn = 0;
          for(int j=0; j<i; j++){ // from 0 to i.
            if(nums[j] < nums[i] && L[j] > maxn) {
              maxn=L[j];
            }
          }
          L[i] = maxn + 1;
        }
        int maxi=0;
        for(int i=0; i< L.length; i++){
          if(L[i] > maxi){
            maxi=L[i];
          }
        }
        return(maxi);
    }

    public static void main(String[] args)
    {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1));
        int[] nums2 = {1, 3, 2};
        System.out.println(lengthOfLIS(nums2));
        int[] nums3 = {1, 1, 1};
        System.out.println(lengthOfLIS(nums3));
        int[] nums4 = {10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS(nums4));
        int[] nums5 = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums5));

        int[] nums6 = {11,12,13,14,15,6,7,8,101,18};
        System.out.println(lengthOfLIS(nums6));
    }
}