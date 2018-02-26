package com.mw.leetcode.p781to790;

import com.mw.ProjectUtil;

import java.util.*;

public class LetterCasePermutation
{
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(S);
        seen.add(S);
        int len = S.length();

        while(!queue.isEmpty())
        {
            Queue<String> temp = new LinkedList<>();
            while (!queue.isEmpty())
            {
                String val = queue.poll();
                char[] array = val.toCharArray();
                for (int i = 0; i < len; i++)
                {
                    char c = array[i];

                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                    {
                        if (c >= 'a' && c <= 'z')
                            array[i] = (char) (c - 32);
                        else
                            array[i] = (char) (c + 32);

                        String ts = String.valueOf(array);
                        if (!seen.contains(ts))
                        {
                            temp.offer(ts);
                            seen.add(ts);
                        }
                        array[i] = c;
                    }
                }
            }
            queue = temp;
        }

        return new ArrayList<>(seen);
    }

    public static void main(String[] args)
    {
        LetterCasePermutation app = new LetterCasePermutation();
        List<String> array = app.letterCasePermutation("12345");
        ProjectUtil.printList(array);
    }
}
