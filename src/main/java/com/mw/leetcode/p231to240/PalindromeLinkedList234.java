package com.mw.leetcode.p231to240;

import com.mw.ProjectUtil;
import com.mw.leetcode.ListNode;

/**
 * Created by mwang on 29/04/2016.
 */
public class PalindromeLinkedList234
{
    public boolean isPalindrome(ListNode head)
    {
        if (head == null || head.next == null)
            return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast slow to find the mid.
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        // reverse the second half.
        ListNode first = head;
        ListNode second = reverse(secondHead);

        while (second != null)
        {
            if (first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }

        // rewalk two list.
        return true;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        dummy.next = head;

        while (cur.next != null)
        {
            ListNode next = cur.next.next;
            ListNode headNext = dummy.next;
            dummy.next = cur.next;
            dummy.next.next = headNext;
            cur.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode head = ProjectUtil.generateList("1->2->3->2->1->NULL");
        PalindromeLinkedList234 app = new PalindromeLinkedList234();
        System.out.println(app.isPalindrome(head));
    }
}
