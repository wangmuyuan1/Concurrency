package com.mw.leetcode.p391to400;

import java.util.Stack;

public class C394DecodeString
{
    private Stack<Object> stack = new Stack<>();

    public String decodeString(String s)
    {
        for (char c : s.toCharArray())
        {
            if (c == ']')
            {
                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() instanceof String)
                {
                    sb.insert(0, (String) stack.pop());
                }

                int multiplier = 1;
                if (!stack.isEmpty() && stack.peek() instanceof Integer)
                {
                    multiplier = (Integer) stack.pop();
                }

                String repeat = sb.toString();
                sb = new StringBuilder();
                for (int i = 0; i < multiplier; i++)
                {
                    sb.append(repeat);
                }

                stack.push(sb.toString()); // Push String back.
                stack.push("");
            }
            else
            {
                if (c == '[')
                {
                    stack.push("");
                }
                else if (Character.isDigit(c))
                {
                    if (stack.isEmpty() || stack.peek() instanceof String)
                    {
                        stack.push(c - '0');
                    }
                    else
                    {
                        stack.push((int) stack.pop() * 10 + (c - '0'));
                    }
                }
                else
                {
                    if (stack.isEmpty() || stack.peek() instanceof Integer)
                    {
                        stack.push(String.valueOf(c));
                    }
                    else
                    {
                        stack.push((String) stack.pop() + c);
                    }
                }
            }
                // peek.
                // if numeric, then combine and push.
                // if it is character / [ straight away.
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
        {
            // pop until empty or number.
            while (!stack.isEmpty() && stack.peek() instanceof String)
            {
                sb.insert(0, stack.pop());
            }
            if (!stack.isEmpty())
            {
                int multiplier = (int) stack.pop();
                String str = sb.toString();
                sb = new StringBuilder();
                for (int i = 0; i < multiplier; i++)
                {
                    sb.append(str);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        C394DecodeString app = new C394DecodeString();
        //System.out.println(app.decodeString("3[a]2[bc]"));
        //System.out.println(app.decodeString("3[a2[c]]"));
        System.out.println(app.decodeString("sd2[f2[e]g]i"));
    }
}
