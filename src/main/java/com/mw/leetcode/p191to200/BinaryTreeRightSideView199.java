package com.mw.leetcode.p191to200;

import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199
{
    // You can see right most tree each layer.
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<NodeWithDepth> queue = new LinkedList<>();
        int curDepth = 1;
        queue.offer(new NodeWithDepth(root, curDepth));
        while (!queue.isEmpty())
        {
            NodeWithDepth temp = queue.poll();
            if (temp.treeNode.left != null)
                queue.add(new NodeWithDepth(temp.treeNode.left, curDepth + 1));
            if (temp.treeNode.right != null)
                queue.add(new NodeWithDepth(temp.treeNode.right, curDepth + 1));

            if (queue.isEmpty() || queue.peek().depth > curDepth) // last node.
            {
                result.add(temp.treeNode.val);
                curDepth++;
            }
        }
        return result;
    }

    class NodeWithDepth
    {
        public TreeNode treeNode;
        public int depth;

        public NodeWithDepth(TreeNode treeNode, int depth)
        {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
