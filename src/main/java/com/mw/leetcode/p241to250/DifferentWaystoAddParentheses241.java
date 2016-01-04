package com.mw.leetcode.p241to250;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses241
{
    // idea, recursive.
    public List<Integer> diffWaysToCompute(String input)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') // we divide.
            {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int m : left)
                    for (int n : right)
                    {
                        switch (c)
                        {
                            case '+':
                                result.add(m + n);
                                break;
                            case '-':
                                result.add(m - n);
                                break;
                            case '*':
                                result.add(m * n);
                                break;
                        }
                    }
            }
        }
        if (result.size() == 0)
            result.add(Integer.valueOf(input));
        return result;
    }
}
