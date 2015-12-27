package com.mw.leetcode.p211to220;

import java.util.HashMap;

public class ContainsDuplicateII219
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k)
            {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
