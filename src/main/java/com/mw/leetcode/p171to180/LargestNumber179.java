package com.mw.leetcode.p171to180;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179
{
    public String largestNumber(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return "";

        String[] values = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            values[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                String s1 = o1 + o2; // take "80" "807" as example
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(values, comparator);

        if (values[values.length - 1].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for(String s: values)
            sb.insert(0, s);

        return sb.toString();
    }
}
