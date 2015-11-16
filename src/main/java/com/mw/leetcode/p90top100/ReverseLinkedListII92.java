package com.mw.leetcode.p90top100;

import com.mw.leetcode.ListNode;

import static com.mw.ListNodeUtil.generateList;
import static com.mw.ListNodeUtil.print;

public class ReverseLinkedListII92
{
    public static ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (m >= n)
            return head;

        int i = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode start = dummyHead;
        ListNode end = dummyHead;
        dummyHead.next = head;
        ListNode temp;
        ListNode dummyNewHead = dummyHead;

        while (i < n)
        {
            if (i < m - 1)
                dummyNewHead = dummyNewHead.next;
            if (i < m)
                start = start.next;
            end = end.next;
            i++;
        }
        int step = n - m;
        while (step > 0)
        {
            ListNode next = start.next; // 1
            ListNode dummyNext = dummyNewHead.next; // 0
            dummyNewHead.next = next; // h -> 1
            if (next != null)
            {
                start.next = next.next; // 0 -> 2
                next.next = dummyNext; // h -> 1 -> 0 -> 2 -> 3
            }
            step--;
        }

        return dummyHead.next;
    }

    public static void main(String[] args)
    {
        ListNode head = generateList("1->2->3->4->5->NULL");
        print(reverseBetween(head, 2, 4));
    }
}
