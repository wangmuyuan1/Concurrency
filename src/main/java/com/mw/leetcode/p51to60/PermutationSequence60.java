package com.mw.leetcode.p51to60;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence60
{
    public static String getPermutation(int n, int k)
    {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>(n);
        for (Integer i = 1; i <= n; i++)
        {
            list.add(i);
        }

        int bucketSize = 1;
        for (int i = 1; i < n; i++)
        {
            bucketSize *= i;
        }
        // 111111,222222,333333, 444444
        while (n > 1)
        {
            // compute bucket size.
            int bucket = (k - 1) / bucketSize; // the ith bucket.
            sb.append(list.get(bucket)); // first digit.
            list.remove(bucket);
            k = k - bucket * bucketSize; // get reminder.
            n--;
            bucketSize = bucketSize / n;
        }

        sb.append(list.get(0));

        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(getPermutation(4, 12));
    }
}
