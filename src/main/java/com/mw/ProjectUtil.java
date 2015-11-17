package com.mw;

import com.mw.leetcode.ListNode;
import com.mw.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ProjectUtil
{
    public static TreeNode generateTree(String s)
    {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (s == null && s.equals(""))
            return null;

        String[] array = s.split(",");

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null || array[i].equals("") || array[i].equals("#"))
                continue;

            queue.add(new TreeNode(Integer.valueOf(array[i])));


        }

        return null;
    }

    public static void printList(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (i < list.size() - 1)
                System.out.print(list.get(i) + ",");
            else
                System.out.print(list.get(i));
        }
    }

    public static ListNode generateList(String s)
    {
        if (s == null && s.equals(""))
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
