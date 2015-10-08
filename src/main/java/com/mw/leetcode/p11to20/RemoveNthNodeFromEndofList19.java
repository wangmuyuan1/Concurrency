package com.mw.leetcode.p11to20;

import com.mw.leetcode.ListNode;

public class RemoveNthNodeFromEndofList19
{
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        // Define dummy slow fast to point to head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;

        ListNode dummy = slow; // always point to head.

        // Walk n step. if only 1 step then fast walk to head.
        // after the loop. the fast is n step ahead slow.
        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        }

        // if fast reaches last node.
        // current slow.next is the one should be removed. because slow starts from a pointer ahead of head.
        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode head = removeNthFromEnd(node, 2);

        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
