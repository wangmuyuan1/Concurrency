package com.mw.leetcode.p711top720;

import java.util.PriorityQueue;

public class MaxStack
{
    class Node implements Comparable<Node>
    {
        int val;
        Node prev;
        Node next;
        int ind; // used when value is same.

        public Node(int val, int ind)
        {
            this.val = val;
            this.ind = ind;
        }

        public int compareTo(Node other)
        {
            if (this.val == other.val)
                return Integer.compare(other.ind, this.ind);
            return Integer.compare(other.val, this.val);
        }
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    int cnt = 0;
    Node head;

    /** initialize your data structure here. */
    public MaxStack() {
        head = new Node(0, 0);
    }

    public void push(int x) {
        Node node = new Node(x, cnt + 1);

        pq.offer(node);

        node.prev = head;
        node.next = head.next;

        if (head.next != null)
        {
            head.next.prev = node;
        }
        head.next = node;

        cnt++;
    }

    public int pop() {
        Node node = head.next;
        pq.remove(node);
        head.next = node.next;
        if (node.next != null)
            node.next.prev = head;
        return node.val;
    }

    public int top() {
        if (head.next == null) return -1;
        return head.next.val; // return the top one.
    }

    public int peekMax() {
        return pq.peek().val;
    }

    public int popMax() {
        Node node = pq.poll();
        node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        return node.val;
    }

    public static void main(String[] args)
    {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println(maxStack.top());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.top());
    }
}
