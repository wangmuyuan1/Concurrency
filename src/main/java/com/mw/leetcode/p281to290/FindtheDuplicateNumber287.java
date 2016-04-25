package com.mw.leetcode.p281to290;

/**
 * Created by mwang on 19/04/2016.
 */
public class FindtheDuplicateNumber287
{
    public int findDuplicate(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
