package com.mw.leetcode.p121to130;

import java.util.HashSet;

public class LongestConsecutiveSequence128
{
    public int longestConsecutive(int[] nums)
    {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (Integer i : nums)
        {
            set.add(i);
        }

        // try to merge using hashmap / hashset to reduce time complexity and skip elements.
        for (Integer i : nums)
        {
            if (visited.contains(i))
                continue;

            int count = 1;
            int temp = i;
            visited.add(temp);
            while (set.contains(temp + 1) && !visited.contains(temp + 1))
            {
                count++;
                temp++;
                visited.add(temp);
            }

            temp = i;
            while (set.contains(temp - 1) && !visited.contains(temp - 1))
            {
                count++;
                temp--;
                visited.add(temp);
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] nums = {-1, 1, 0};
        LongestConsecutiveSequence128 app = new LongestConsecutiveSequence128();
        System.out.println(app.longestConsecutive(nums));
    }
}