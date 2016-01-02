package com.mw.leetcode.p311top320;

public class MaximumProductofWordLengths318
{
    public int maxProduct(String[] words)
    {
        if (words == null || words.length <= 1)
            return 0;

        // Create mask.
        int[] mask = new int[words.length]; // each integer can represent the occurance of all alphabets.
        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words[i].length(); j++)
                mask[i] = mask[i] | 1 << (words[i].charAt(j) - 'a');

        // Use mask to calculate the length;
        int max = 0;
        for (int i = 0; i < mask.length; i++)
        {
            for (int j = i + 1; j < mask.length; j++)
            {
                if ((mask[i] & mask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new MaximumProductofWordLengths318().maxProduct(words));
    }
}
