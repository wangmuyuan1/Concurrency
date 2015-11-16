package com.mw.leetcode.p141to150;

import com.mw.leetcode.ListNode;

public class SortList148
{
    public static ListNode sortList(ListNode head)
    {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode resultHead = new ListNode(0);

        ListNode dummy1;
        ListNode dummy2;
        ListNode dummyResult = resultHead; // this is good way of merging two list.

        // find middle pivot.
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        dummyHead2.next = slow.next;
        dummyHead1.next = head;
        slow.next = null; // terminate slow list.

        dummy1 = mergeSort(dummyHead1.next);
        dummy2 = mergeSort(dummyHead2.next);

        while (dummy1 != null && dummy2 != null)
        {
            ListNode smaller;

            if (dummy1.val <= dummy2.val)
            {
                smaller = dummy1;
                dummy1 = dummy1.next;
            }
            else
            {
                smaller = dummy2;
                dummy2 = dummy2.next;
            }

            dummyResult.next = smaller;
            dummyResult = dummyResult.next;
        }

        if (dummy1 != null)
        {
            dummyResult.next = dummy1;
        }
        if (dummy2 != null)
        {
            dummyResult.next = dummy2;
        }

        return resultHead.next;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        ListNode result = mergeSort(head);
        while (result != null)
        {
            System.out.print(result.val + "->");
            result =result.next;
        }
    }
}
