package com.mw.leetcode.p11to20;

import java.util.Stack;

public class ValidParentheses20
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char last = stack.pop();
                if ((s.charAt(i) == ')' && last != '(') ||
                        (s.charAt(i) == ']' && last != '[') ||
                        (s.charAt(i) == '}' && last != '{')
                        )
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {

    }
}
