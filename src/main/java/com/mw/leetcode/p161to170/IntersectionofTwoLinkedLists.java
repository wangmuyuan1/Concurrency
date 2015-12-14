package com.mw.leetcode.p161to170;

import com.mw.leetcode.ListNode;

public class IntersectionofTwoLinkedLists
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        int l1 = 0;
        int l2 = 0;
        ListNode ha = headA;
        while (ha != null)
        {
            ha = ha.next;
            l1++;
        }

        ListNode hb = headB;
        while (hb != null)
        {
            hb = hb.next;
            l2++;
        }

        ha = headA;
        hb = headB;
        if (l1 > l2)
        {

            int diff = l1 - l2;
            while (diff > 0)
            {
                ha = ha.next;
                diff--;
            }
        }
        else if (l1 < l2)
        {
            int diff = l2 - l1;
            while (diff > 0)
            {
                hb = hb.next;
                diff--;
            }
        }

        while (ha != null && hb != null)
        {
            if (ha == hb)
                return ha;
            else
            {
                ha = ha.next;
                hb = hb.next;
            }
        }
        return null;
    }
}
