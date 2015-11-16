package com.mw;

import com.mw.leetcode.ListNode;

public class ListNodeUtil
{
    public static ListNode generateList(String s)
    {
        if (s == "")
            return null;

        String[] vals = s.split("->");
        ListNode head = new ListNode(Integer.valueOf(vals[0]));
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++)
        {
            if (!vals[i].equalsIgnoreCase("null"))
            {
                cur.next = new ListNode(Integer.valueOf(vals[i]));
            }
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        print(generateList("1->2->3->4->5->NULL"));
    }
}
