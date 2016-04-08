package com.mw.leetcode.p331to340;

import com.mw.ProjectUtil;

import java.util.*;

/**
 * Created by mwang on 07/04/2016.
 */
public class PalindromePairs
{

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if (words == null) return result;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i)
        {
            map.put(words[i], i); // store all the word and its index.
        }

        // Use two pointer to calc the pre post fix?
        for (int i = 0; i < words.length; ++ i)
        {
            int l = 0, r = 0;
            // from only left a*******
            while (l <= r)
            {
                String s = words[i].substring(l, r); // get ""
                Integer j = map.get(new StringBuilder(s).reverse().toString()); // get reversed string Index. have reversed prefix?
                int start = l == 0 ? r : 0; // if left is 0 then it is right. check either [r, words[i].length] or [0, l]
                int end = l == 0 ? words[i].length() : l; // if left is 0 then it is last. if it is l = 0 r = 0 then it is abcdetea
                if (j != null
                        && i != j
                        && isPalindrome(words[i].substring(start, end)))// if l == 0, the start = r...words[i].length, else it is 0 : l,
                    result.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));// if l == 0, the start = r...words[i].length, else it is 0 : l,
                if (r < words[i].length()) ++r;
                else ++l;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s)
    {
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs app = new PalindromePairs();
        ProjectUtil.printList(app.palindromePairs(words));
    }
}
