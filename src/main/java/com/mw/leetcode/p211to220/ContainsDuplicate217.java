package com.mw.leetcode.p211to220;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217
{
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> result = new HashSet<>();

        for (int num : nums)
        {
            if (!result.add(new Integer(num)))
                return true;
        }
        return false;
    }
}
