package com.mw.leetcode.p151to160;

import java.util.Stack;

public class MinStack155
{
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    public void push(int x)
    {
        if (x <= min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x); //如果x <= min的时候我们其实push了两次，首先把之前的minPush进去，再pushX;
        // 如果是一下顺序 10, 9, 8, 12那push完之后的结构是MAX, 10, 10, 9, 9, 8, 12 同时min为8.
    }

    public void pop()
    {
        //假设此时顺序为MAX, 10, 10, 9, 9, 8, 同时min为8.
        int peek = stack.pop(); //这时候顺序为MAX, 10, 10, 9, 9, min = 8, peak = 8
        if (peek == min){
            min = stack.pop(); //第二次peak的意思是把之前多加的一个min给pop出来为min。
        }
        // 假设是MAX, 10的话，min = 10
        // 那pop第一次出来10，pop第二次出来最大值
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return this.min;
    }
}
