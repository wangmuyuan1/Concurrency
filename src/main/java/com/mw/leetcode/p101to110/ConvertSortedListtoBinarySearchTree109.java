package com.mw.leetcode.p101to110;

import com.mw.ProjectUtil;
import com.mw.leetcode.ListNode;
import com.mw.leetcode.TreeNode;

// TAG: [TREE] [RECURSIVE]
public class ConvertSortedListtoBinarySearchTree109
{
    public TreeNode sortedListToBST(ListNode head)
    {
        return sortedArrayToBSTRec(head);
    }

    private TreeNode sortedArrayToBSTRec(ListNode head)
    {
        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        ListNode second = slow.next;
        pre.next = null; // terminate list.
        node.left = sortedListToBST(head);
        if (second != null)
            node.right = sortedListToBST(second);

        return node;
    }

    public static void main(String[] args)
    {
        ListNode head = ProjectUtil.generateList("1->2->3->4->5->6->7->8->9->NULL");

        ConvertSortedListtoBinarySearchTree109 app = new ConvertSortedListtoBinarySearchTree109();
        ProjectUtil.printTree(app.sortedListToBST(head));
    }
}
