package com.mw.leetcode.p321top330;

import com.mw.leetcode.ListNode;

public class OddEvenLinkedList328
{
    public ListNode oddEventList(ListNode head)
    {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
