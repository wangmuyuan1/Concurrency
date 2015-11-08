package com.mw.leetcode.p291to300;

import java.util.*;

public class RemoveInvalidParentheses301
{
    public static List<String> removeInvalidParentheses(String s)
    {
        List<String> result = new ArrayList<>();

        if (isValid(s))
        {
            result.add(s);
            return result;
        }

        // For each char: remove this char, if it is valid add it to the queue.
        Set<String> visited = new HashSet<>(); // store the visited string, to speed up. VERY IMPORTANT.
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        int min = -1;
        while (!queue.isEmpty())
        {
            String cur = queue.remove();

            if (min != -1 && cur.length() < min)
                break;

            if (isValid(cur))
            {
                if (!result.contains(cur))
                {
                    result.add(cur);
                    min = cur.length();
                }
            }
            else
            {
                for (int i = 0; i < cur.length(); i++)
                {
                    char c = s.charAt(i);
                    if (c != '(' && c != ')')
                        continue;
                    String newStr = cur.substring(0, i) + cur.substring(i + 1);
                    if (!visited.contains(newStr))
                    {
                        visited.add(newStr);
                        queue.add(newStr);
                    }
                }
            }
        }

        if (result.isEmpty())
        {
            result.add("");
        }
        return result;
    }

    public static boolean isValid(String s)
    {
        int count = 0; // IMPORTANT: use variable to replace use of stack.
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
                count++;
            if (c == ')' && count-- == 0)
                    return false;
        }
        return count == 0;
    }

    public static void main(String[] args)
    {
        for (String s : removeInvalidParentheses("x("))
            System.out.println(s);

//        System.out.print(isValid("("));
    }
}
