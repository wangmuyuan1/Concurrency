package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;
import com.mw.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersII117
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
                // right may be empty.
                if (cur.right != null)
                {
                    cur.left.next = cur.right;
                }
                else
                {
                    cur.left.next = getNext(cur);
                }


                queue.offer(cur.left);
            }

            if (cur.right != null)
            {
                if (cur.next != null)
                {
                    cur.right.next = getNext(cur);
                }
                else
                    cur.right.next = null;

                queue.offer(cur.right);
            }
        }
    }

    private TreeLinkNode getNext(TreeLinkNode cur)
    {
        TreeLinkNode temp = cur.next;
        while (temp != null)
        {
            if (temp.left != null)
            {
                return temp.left;
            }
            else if (temp.right != null)
            {
                return temp.right;
            }
            else
                temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        TreeLinkNode root = ProjectUtil.generateTreeLink("1,2,3,4,5,#,6,7,#,#,#,#,8");
        PopulatingNextRightPointersII117 app = new PopulatingNextRightPointersII117();
        app.connect(root);
        System.out.println(root);
    }
}
