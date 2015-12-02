package com.mw.leetcode.p141to150;

import com.mw.leetcode.ListNode;

public class LinkedListCycleII142
{
    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next ==null)
            return null;
        ListNode slower = head;
        ListNode faster = head;
        boolean hasCycle = false;
        while (faster != null && faster.next != null)
        {
            slower = slower.next;
            faster = faster.next.next;
            if (faster == slower)
            {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return null;

        slower = head;
        while( slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }

        return slower;
    }

    public static void main(String[] args)
    {

    }
}
