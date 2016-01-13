package com.mw.leetcode.p321top330;

public class CountofRangeSum327
{
    //The issue on this problem is we should sum the range from 0 to n and then do a substraction.

    public int countRangeSumEasy(int[] nums, int lower, int upper)
    {
        int count = 0;
        int[] sum = new int[nums.length + 1]; // index 0 is 0.
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j <= nums.length; j++)
            {
                if (sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper)
                    count++;
            }
        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper)
    {
        int[] sum = new int[nums.length + 1]; // index 0 is 0.
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];

        return merge(sum, 0, sum.length, lower, upper);
    }

    public int merge(int[] sums, int start, int end, int lower, int upper)
    {
        if (end - start <= 1)
            return 0;

        int mid = (start + end) / 2;
        int count = merge(sums, start, mid, lower, upper) + merge(sums, mid, end, lower, upper);

        int j = mid; // upper bound.
        int k = mid; // lower bound.
        int r = 0;
        int t = mid;
        int[] cache = new int[end - start];
        for (int i = start; i < mid; i++)
        {
            while (k < end && sums[k] - sums[i] < lower) k++; // find lower bound.
            while (j < end && sums[j] - sums[i] <= upper) j++; // find upper bound.

            // the next three lines are merge. [0, mid - 1] [mid, end]
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++]; // find those one smaller than i and move them into cache.
            cache[r] = sums[i]; // set r = i;
            r++;
            count += j - k; // the nums of combination in this iteration.
        }

        // at this point cache should be full, r == t == end;
        System.arraycopy(cache, 0, sums, start, t - start); // copy the sorted array into the original sum.
        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {-2, 5, -1};
        CountofRangeSum327 app = new CountofRangeSum327();
        System.out.println(app.countRangeSum(nums, -2, 2));
    }
}