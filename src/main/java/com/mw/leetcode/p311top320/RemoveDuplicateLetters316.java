package com.mw.leetcode.p311top320;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters316
{
    public String removeDuplicateLetters(String s)
    {
        Map<Character, Integer> cnts = new HashMap<>(); // Holds how many counts that each char appeared.
        StringBuilder sb = new StringBuilder(); // final String?
        Stack<Character> stack = new Stack<>(); // the stack of chars, which only appear once.
        boolean[] visited = new boolean[26]; // if char has been visited?
        for (char c : s.toCharArray())
            cnts.put(c, cnts.containsKey(c) ? cnts.get(c) + 1 : 1);
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            // When to skip? 1. c has been visited. 2. c is the top char in stack.
            if (visited[c - 'a'] || (!stack.isEmpty() && stack.peek() == c))
            {
                cnts.put(c, cnts.get(c) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && cnts.get(stack.peek()) > 0)
            {
                char pop = stack.pop(); // when to pop?
                visited[pop - 'a'] = false; // it is not in the stack anymore.
            }
            stack.push(c);
            visited[c - 'a'] = true;
            cnts.put(c, cnts.get(c) - 1); // if the c is the last one of the char then
            // cnts.get(stack.peek()) will be 0 and c will remain in stack.
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new RemoveDuplicateLetters316().removeDuplicateLetters("bbcaac"));
    }
}
