package com.mw;

import com.mw.leetcode.ListNode;
import com.mw.leetcode.TreeNode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ProjectUtil
{
    public static TreeNode generateTree(String s)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        if (s == null && s.equals(""))
            return null;

        String[] array = s.replaceAll("\\[","").replaceAll("\\]", "").split(",");
        if (array[0] == null || array[0].equals("") || array[0].equals("#") || array[0].equalsIgnoreCase("null"))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        queue.add(root);

        for (int i = 1; i < array.length; i = i + 2)
        {
            TreeNode node = queue.poll();
            if (node == null)
            {
                throw new RuntimeException("Invalid Tree!");
            }

            if (array[i] != null && !array[i].equals("") && !array[i].equals("#") && !array[i].equalsIgnoreCase("null")) // left val valid
            {
                TreeNode leftChild = new TreeNode(Integer.valueOf(array[i]));
                node.left = leftChild;
                queue.add(leftChild);
            }

            if (i + 1 < array.length && array[i + 1] != null && !array[i + 1].equals("") && !array[i + 1].equals("#") && !array[i + 1].equalsIgnoreCase("null")) // right val valid.
            {
                TreeNode rightChild = new TreeNode(Integer.valueOf(array[i + 1]));
                node.right = rightChild;
                queue.add(rightChild);
            }

            if(
                    (array[i] == null || array[i].equals("") || array[i].equals("#") || array[i].equalsIgnoreCase("null"))
                && (array[i + 1] == null || array[i + 1].equals("") || array[i + 1].equals("#") || array[i + 1].equalsIgnoreCase("null"))
                    )
            {
                node.left = null;
                node.right = null;
            }
        }

        return root;
    }

    public static TreeLinkNode generateTreeLink(String s)
    {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (s == null && s.equals(""))
            return null;

        String[] array = s.replaceAll("\\[","").replaceAll("\\]", "").split(",");
        if (array[0] == null || array[0].equals("") || array[0].equals("#") || array[0].equalsIgnoreCase("null"))
        {
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(Integer.valueOf(array[0]));
        queue.add(root);

        for (int i = 1; i < array.length; i = i + 2)
        {
            TreeLinkNode node = queue.poll();
            if (node == null)
            {
                throw new RuntimeException("Invalid Tree!");
            }

            if (array[i] != null && !array[i].equals("") && !array[i].equals("#") && !array[i].equalsIgnoreCase("null")) // left val valid
            {
                TreeLinkNode leftChild = new TreeLinkNode(Integer.valueOf(array[i]));
                node.left = leftChild;
                queue.add(leftChild);
            }

            if (i + 1 < array.length && array[i + 1] != null && !array[i + 1].equals("") && !array[i + 1].equals("#") && !array[i + 1].equalsIgnoreCase("null")) // right val valid.
            {
                TreeLinkNode rightChild = new TreeLinkNode(Integer.valueOf(array[i + 1]));
                node.right = rightChild;
                queue.add(rightChild);
            }

            if(
                    (array[i] == null || array[i].equals("") || array[i].equals("#") || array[i].equalsIgnoreCase("null"))
                && (array[i + 1] == null || array[i + 1].equals("") || array[i + 1].equals("#") || array[i + 1].equalsIgnoreCase("null"))
                    )
            {
                node.left = null;
                node.right = null;
            }
        }

        return root;
    }

    public static void printTree(TreeNode node)
    {
        Stack<TreeNode> globalStack = new Stack<>();
        globalStack.push(node);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(!isRowEmpty)
        {
            Stack<TreeNode> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');
            while(!globalStack.isEmpty())
            {
                TreeNode temp = globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.val);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null ||temp.right != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j< emptyLeaf *2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while(!localStack.isEmpty())
                globalStack.push( localStack.pop() );
        }
        System.out.println("****......................................................****");
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

    public static void printIntArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (i < array.length - 1)
                System.out.print(array[i] + ",");
            else
                System.out.print(array[i]);
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

    private static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void printDate(String start, String end)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        while (!startDate.isAfter(endDate))
        {
            System.out.println(startDate);
            startDate = startDate.plusDays(1);
        }
    }

    public static void main(String[] args)
    {
        printDate("2015-10-18", "2016-04-13");
    }
}
