package com.mw.leetcode.p421to430;

/**
 * Created by mwang on 17/10/2016.
 */
public class LongestRepeatingCharReplacement424
{
    static class Solution
    {
        public int characterReplacement(String s, int k)
        {
            int max = 0;
            char[] array = s.toCharArray();
            int[] dic = new int[26];
            for (int i = 0, j = 0; i < array.length; i++)
            {
                // get current max char.
                for (;j < array.length;)
                {
                    dic[array[j] - 'A']++; // try to extend window.
                    int len = j - i + 1;
                    if (len - getMostRepeating(dic) > k)
                    {
                        dic[array[j] - 'A']--;
                        break; // break, cause already get k;
                    }
                    j++;
                }

                max = Math.max(j - i, max);
                dic[array[i] - 'A']--; // window slide to right.
            }

            return max;
        }

        public int getMostRepeating(int[] dic)
        {
            int most = 0;
            for (int num : dic)
                most = Math.max(num, most);
            return most;
        }
    }

    public static void main(String[] args)
    {
        Solution app = new Solution();
        //System.out.println(app.characterReplacement("ABAB", 1));
        System.out.println(app.characterReplacement("ABBB", 2));
        System.out.println(app.characterReplacement("ABBABAA", 2));
    }
}
