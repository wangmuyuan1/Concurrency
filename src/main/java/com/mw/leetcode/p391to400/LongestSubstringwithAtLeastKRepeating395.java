package com.mw.leetcode.p391to400;

/**
 * Created by mwang on 17/10/2016.
 */
public class LongestSubstringwithAtLeastKRepeating395
{
    static class Solution
    {
        public int longestSubstring(String s, int k)
        {
            return dfs(s.toCharArray(), 0, s.length(), k);
        }

        private int dfs(char[] array, int start, int end, int k)
        {
            if (start > end)
                return 0;

            if (end - start < k)
                return 0;

            // check if all letter appears k times at least.
            int[] dict = new int[26];
            for (int i = start; i < end; i++)
            {
                dict[array[i] - 'a']++;
            }
            int max = end - start;
            for (int i = 0; i < dict.length; i++)
            {
                if (dict[i] == 0) continue;

                if (dict[i] < k)
                {
                    // divide on conquer on every division.
                    for(int j = start; j < end;j++)
                    {
                        if(array[j]== i + 'a')
                        {
                            int left = dfs(array,start,j,k);
                            int right = dfs(array,j + 1,end,k);
                            max = Math.max(left,right);
                        }
                    }
                }
            }

            return max;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.longestSubstring("aaabb", 3));
    }
}
