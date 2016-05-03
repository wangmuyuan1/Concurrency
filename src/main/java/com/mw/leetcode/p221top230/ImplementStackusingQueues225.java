package com.mw.leetcode.p221top230;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mwang on 01/05/2016.
 */
public class ImplementStackUsingQueues225
{
    Queue<Integer> curQueue = new LinkedList<>();
    Queue<Integer> stack = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        curQueue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int n = curQueue.size();
        for (int i = 0; i < n - 1; i++)
            stack.offer(curQueue.poll()); // n - 1.

        Queue<Integer> temp = curQueue;
        temp.clear();
        curQueue = stack;
        stack = temp; // swap
    }

    // Get the top element.
    public int top() {
        int val = -1;
        while (!curQueue.isEmpty())
        {
            val = curQueue.poll();
            stack.add(val);
        }
        Queue<Integer> temp = curQueue;
        temp.clear();
        curQueue = stack;
        stack = temp;

        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return curQueue.isEmpty();
    }

    public static void main(String[] args)
    {
        ImplementStackUsingQueues225 app = new ImplementStackUsingQueues225();
        app.push(1); app.push(2);
        System.out.println(app.top());
    }
}
