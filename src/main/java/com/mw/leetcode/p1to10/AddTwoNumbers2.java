package com.mw.leetcode.p1to10;

import com.mw.leetcode.ListNode;

public class AddTwoNumbers2
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int currentVal = 0;
        ListNode s1 = l1;
        ListNode s2 = l2;
        ListNode result = null, current = null;
        while (s1 != null || s2 != null)
        {
            currentVal += (s1 == null ? 0 : s1.val) + (s2 == null ? 0 : s2.val);
            if (current == null)
            {
                current = new ListNode(currentVal % 10);
            }
            else
            {
                current.next = new ListNode(currentVal % 10);
                current = current.next;
            }

            currentVal /= 10;

            if (result == null)
            {
                result = current;
            }

            if (s1 != null)
            {
                s1 = s1.next;
            }

            if (s2 != null)
            {
                s2 = s2.next;
            }
        }

        if (currentVal > 0)
        {
            current.next = new ListNode(1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        //Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        //Output: 7 -> 0 -> 8
        ListNode s1 = new ListNode(2);
        s1.next = new ListNode(4);
        s1.next.next = new ListNode(3);

        ListNode s2 = new ListNode(5);
        s2.next = new ListNode(6);
        s2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(s1, s2);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
