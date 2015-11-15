package com.mw.leetcode.p81to90;

import com.mw.leetcode.ListNode;

public class PartitionList86
{
    public static ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
            return head;

        ListNode dummyLess = new ListNode(0);
        ListNode dummyGreat = new ListNode(0);
        dummyLess.next = head;
        // from head, we need to find a next less than x value to assign to dummy.next
        ListNode cur = head;
        ListNode dummy1 = dummyLess;
        ListNode dummy2 = dummyGreat;
        while (cur != null)
        {
            if (cur.val < x)
            {
                cur = cur.next; //orig pointer move ahead.
                dummy1 = dummy1.next; //less pointer move ahead.
            }
            else
            {
                dummy2.next =cur; // add to greater list.
                dummy1.next =cur.next; // less pointer point to next dummy. but less pointer doesnt move, this is temp holder.

                cur = dummy1.next; // set temp to cur.
                dummy2 = dummy2.next; // move greater ahead.
            }
        }
        dummy2.next = null;
        // merge dummyLess and dummyGreater.
        dummy1.next =dummyGreat.next;
        return dummyLess.next;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        partition(head, 2);
    }
}
