package com.mw.leetcode.p21top30;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22
{
    /**
     * Left Right parenthesis approach.
     * @param n
     * @return
     */
    public static List<String> generateParenthesisLeftRight(int n)
    {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    public static void dfs(List<String> result, String s, int left, int right)
    {
        if (left > right)
        {
            return;
        }

        if (left == 0 && right == 0)// finished.
        {
            result.add(s);
            return;
        }

        if (left > 0)
        {
            dfs(result, s + "(", left - 1, right);
        }

        if (right > 0)
        {
            dfs(result, s + ")", left, right - 1);
        }
    }

    public static List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();

        if (n == 1)
        {
            result.add("()");
        }

        if (n > 1)
        {
            // Rec
            List<String> tmp = generateParenthesis(n - 1);

            for (String s : tmp)
            {
                // embrace.
                result.add("(" + s + ")");
                // add before.
                result.add("()" + s);
                if (!("()" + s).equals(s + "()"))
                {
                    // add after.
                    result.add(s + "()");
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        generateParenthesisLeftRight(4).forEach(System.out::println);
    }
}
