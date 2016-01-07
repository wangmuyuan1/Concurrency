package com.mw.leetcode.p221top230;

import java.util.Stack;

public class BasicCalculator224
{
    public int calculate(String s)
    {
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if(c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;
            } else if(c == '(') {
                stack.push(sign);
            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }



    public static void main(String[] args)
    {
        //3-((5-6)-((7-8) + 2))
        System.out.println(new BasicCalculator224().calculate("((-3-(1-4)))"));
    }
}
