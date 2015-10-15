package com.mw.leetcode.p82to83;

import com.mw.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList83
{
    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = head;

        ListNode prev = null;

        int val = Integer.MAX_VALUE;
        while (walker != null)
        {
            if (walker.val != val)
            {
                val = walker.val;
                prev = walker;
                walker = walker.next;
            }
            else
            {
                while(walker !=null)
                {
                    if (walker.val == val && walker.next != null)
                    {
                        walker = walker.next;
                    }
                    else if (walker.val != val)
                    {
                        // find next node to connect to.
                        prev.next = walker;
                        val = walker.val;
                        prev = walker;
                        walker = walker.next;
                        break;
                    }
                    else // last node.
                    {
                        prev.next = null;
                        walker = walker.next;
                        break;
                    }
                }
            }
        }

        return head;
    }

    public static void main(String[] args)
    {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);

        head = deleteDuplicates(head);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
