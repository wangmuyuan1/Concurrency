package com.mw.leetcode.p141to150;

import com.mw.leetcode.ListNode;

public class InsertionSortList147
{
    public ListNode insertionSortList(ListNode head)
    {
        ListNode dummy = new ListNode(-1);;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;
        while (cur != null)
        {
            while (pre.next != null && pre.next.val < cur.val)
            {
                pre = pre.next;
            }
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
}
