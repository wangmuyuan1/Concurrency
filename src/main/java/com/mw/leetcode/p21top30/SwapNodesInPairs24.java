package com.mw.leetcode.p21top30;

public class SwapNodesInPairs24
{
    public ListNode swapPairs(ListNode head)
    {
        ListNode cur = head;
        ListNode prev = null;
        ListNode headPointer = new ListNode(-1);
        headPointer.next = head;

        while (cur != null && cur.next != null)
        {
            ListNode firstNext = cur.next;

            // 0 should go for 2
            cur.next = firstNext.next;

            // 1 should go for 0
            firstNext.next = cur;

            // -1 should go for 1
            if (prev == null)
            {
                prev = headPointer;
            }
            prev.next = firstNext;
            prev = cur;
            cur = cur.next;
        }
        return headPointer.next;
    }

    public static void main(String[] args)
    {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
