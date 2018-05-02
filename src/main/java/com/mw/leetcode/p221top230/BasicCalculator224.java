package com.mw.leetcode.p221top230;

import java.util.Stack;

public class BasicCalculator224
{
    public int calculate(String s)
    {
        if (s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();

        int res = 0;
        int sign = 1;
        int num = 0;
        s = "(" + s + ")";

        for (char c : s.toCharArray())
        {
            switch (c)
            {
                case '+':
                    res += sign * num;
                    sign = 1;
                    num = 0;
                    break;
                case '-':
                    res += sign * num;
                    sign = -1;
                    num = 0;
                    break;
                case '(':
                    stack.push(sign);
                    resStack.push(res);
                    res = 0;
                    sign = 1;
                    num = 0;
                    break;
                case ')':
                    res += sign * num; // cur
                    sign = stack.pop();
                    res = resStack.pop() + sign * res;
                    num = 0;
                    break;
                case ' ':
                    continue;
                default:
                    num = num * 10 + (c - '0');
            }
        }

        return res;
    }



    public static void main(String[] args)
    {
        //3-((5-6)-((7-8) + 2))
        System.out.println(new BasicCalculator224().calculate("(4+5+2)"));
    }
}
