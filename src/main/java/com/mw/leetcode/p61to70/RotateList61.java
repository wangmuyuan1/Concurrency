package com.mw.leetcode.p61to70;

import com.mw.leetcode.ListNode;

public class RotateList61
{
    public static ListNode rotateRight(ListNode head, int k)
    {
        if (head == null)
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode walker = dummy;
        while (walker.next != null)
        {
            walker = walker.next;
            length++;
        }

        int step = length - k % length;
        int i = 0;

        // find the break point.
        walker = dummy;
        while (i < step)
        {
            walker = walker.next;
            i++;
        }

        // relink the next to head.
        dummy.next = walker.next;

        //break the end of the chain.
        walker.next = null;

        walker = dummy;
        while (walker.next != null)
        {
            walker = walker.next;
        }
        walker.next = head;

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode dummy = new ListNode(0);
        ListNode walker = dummy;
        for (int i = 1; i <= 5; i++)
        {
            walker.next = new ListNode(i);
            walker = walker.next;
        }

        walker = rotateRight(dummy.next, 2);
        while (walker != null)
        {
            System.out.println(walker.val);
            walker = walker.next;
        }
    }
}
