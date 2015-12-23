package com.mw.leetcode.p201to210;

import com.mw.ProjectUtil;
import com.mw.leetcode.ListNode;

public class RemoveLinkedListElements203
{
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null)
        {
            if (cur.next != null && cur.next.val == val)
            {
                cur.next = cur.next.next;
            }
            else
            {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode head = ProjectUtil.generateList("1->2->1->1->NULL");
        head = new RemoveLinkedListElements203().removeElements(head, 1);
        ProjectUtil.print(head);
    }
}
