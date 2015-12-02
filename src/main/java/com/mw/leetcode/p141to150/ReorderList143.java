package com.mw.leetcode.p141to150;

import com.mw.leetcode.ListNode;

public class ReorderList143
{
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null)
            return;
        // faster slower to find the median.
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse latter part.
        ListNode preMid = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null)
        {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMid.next;
            preMid.next = current;
        }

        // merge list.
        p2 = preMid.next;
        p1 = head;
        while (p1 != preMid)
        {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
