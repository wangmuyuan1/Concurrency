package com.mw.leetcode.p82to83;

import com.mw.leetcode.ListNode;

public class RemoveDuplicatesFromSortedListII82
{
    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        int val = head.val; // value of first node.
        ListNode walker = head.next; // next to head. could be null.
        while (walker != null)
        {
            if (walker.val != val) // if it is the second node from the head.
                                   // then the head is fixed non-repeat. we can move prev to it.
            {
                prev = prev.next; // move 1 step forward.
                val = walker.val;
                walker = walker.next;
            }
            else // else means the two consecutive nodes from head are equals. we need to found next node not equals to it.
            {
                while(walker !=null)
                {
                    if (walker.val == val && walker.next != null) // not the last node.
                    {
                        walker = walker.next;
                    }
                    else if (walker.val != val)
                    {
                        // find next node to connect to. but we dont want to move prev as the node could still be duplicated.
                        prev.next = walker;
                        val = walker.val;
                        walker = walker.next;
                        break;
                    }
                    else // last node. then terminate.
                    {
                        prev.next = null;
                        walker = walker.next;
                        break;
                    }
                }
            }
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
//        ListNode node = new ListNode(1);
//        ListNode head = node;
//        node.next = new ListNode(2);

        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(4);

        head = deleteDuplicates(head);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
