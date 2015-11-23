package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;
import com.mw.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

// TAG: [TREE]
public class PopulatingNextRightPointers116
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;
        TreeLinkNode cur = null;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            cur = queue.poll();
            if (cur.left != null)
            {
                cur.left.next = cur.right;
                queue.offer(cur.left);
            }

            if (cur.right != null)
            {
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                else
                    cur.right.next = null;

                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args)
    {
        TreeLinkNode root = ProjectUtil.generateTreeLink("1,2,3,4,5,6,7");
        PopulatingNextRightPointers116 app = new PopulatingNextRightPointers116();
        app.connect(root);
        System.out.println(root);
    }
}