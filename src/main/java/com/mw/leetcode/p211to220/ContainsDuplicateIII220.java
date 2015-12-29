package com.mw.leetcode.p211to220;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII220
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        // hint: binary tree, why?
        if (nums == null || nums.length == 0)
            return false;

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE; // this is to make the number large enough.
            long bucket = remappedNum / ((long) t + 1); // calc bucket
            if (map.containsKey(bucket) // has the value in range. mmmmmm
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) // has value in previous bucket and the value difference less than t.
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) // has value in next bucket and the value difference less than t.
                    )
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);// put the last number of the bucket.
        }
        return false;
    }
}

class TreeNodeWithIndex
{
    public int val;
    public int index;
    public TreeNodeWithIndex left;
    public TreeNodeWithIndex right;
    public TreeNodeWithIndex(int index, int val)
    {
        this.index = index;
        this.val = val;
    }

    public static void main(String[] args)
    {
        int[] nums = {7, 1, 3};
        System.out.println(new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
