package com.mw.leetcode.p241to250;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses241
{
    // idea, recursive.

    public List<Integer> diffWaysToCompute(String input)
    {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); i++)
        {
            // compute the left and compute the right and then sum
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*')
            {
                List<Integer> leftResults =diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));

                for (int m : leftResults)
                {
                    for (int n : rightResults)
                    {
                        switch (c)
                        {
                            case '+':
                                results.add(m + n);
                                break;
                            case '-':
                                results.add(m - n);
                                break;
                            case '*':
                                results.add(m * n);
                                break;
                        }
                    }
                }
            }
        }
        if (results.size() == 0)
            results.add(Integer.valueOf(input));
        return results;
    }

    public static void main(String[] args)
    {
        DifferentWaystoAddParentheses241 app = new DifferentWaystoAddParentheses241();
        ProjectUtil.printList(app.diffWaysToCompute("2-1-1"));
    }


}
