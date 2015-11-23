package com.mw.leetcode.p141to150;

import java.util.Stack;

// TAG: [STACK]
public class EvaluateReversePolishNotation150
{
    public int evalRPN(String[] tokens)
    {
        if (tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int temp = 0;
                switch (tokens[i])
                {
                    case "+":
                        temp = num1 + num2;
                        break;
                    case "-":
                        temp = num1 - num2;
                        break;
                    case "*":
                        temp = num1 * num2;
                        break;
                    case "/":
                        temp = num1 / num2;
                        break;
                }
                stack.push(temp);
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();
    }

    public static void main(String[] args)
    {
        String[] tokens = {"4", "13", "5", "/", "+"};
        EvaluateReversePolishNotation150 app = new EvaluateReversePolishNotation150();
        System.out.println(app.evalRPN(tokens));
    }
}
