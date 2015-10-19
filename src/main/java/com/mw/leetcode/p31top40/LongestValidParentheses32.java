package com.mw.leetcode.p31top40;

import java.util.Stack;

public class LongestValidParentheses32
{
    public static int longestValidParentheses(String s)
    {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        if (s.length() == 0)
        {
            return max;
        }

        int i = 0;
        int length = 0;
        int last = -1;
        while (i < s.length())
        {
            if (s.charAt(i) ==  '(') // push index into stack anyway.
            {
                stack.push(i);
            }
            else // ')'
            {
                if (stack.isEmpty()) // if it is empty, last = i.
                {
                    last = i;
                }
                else
                {
                    stack.pop(); // pop anyway.

                    if (stack.isEmpty()) // if it is empty after pop.
                        length = Math.max(i - last, length);
                    else
                        length = Math.max(i - stack.peek(), length);// current position to the top element index in the queue.
                }
            }
            i++;
        }

        return length;
    }

    public static void main(String[] args)
    {
//        System.out.println(longestValidParentheses("()(()"));
//        System.out.println(longestValidParentheses("()()"));
//        System.out.println(longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses("(()(((()"));
        System.out.println(longestValidParentheses("(()()"));
    }
}
