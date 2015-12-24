package com.mw.leetcode.p201to210;

import com.mw.ProjectUtil;
import com.mw.leetcode.ListNode;

public class ReverseLinkedList
{
    public ListNode reverseList(ListNode head)
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null)
        {
            ListNode newHead = cur.next;
            ListNode next = cur.next.next;
            newHead.next = dummy.next;
            dummy.next = newHead;
            cur.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode node = ProjectUtil.generateList("1->2->3->4->NULL");
        ProjectUtil.print(new ReverseLinkedList().reverseList(node));
    }
}
