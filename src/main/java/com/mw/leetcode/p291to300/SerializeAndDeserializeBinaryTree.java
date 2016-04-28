package com.mw.leetcode.p291to300;

import com.mw.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mwang on 27/04/2016.
 */
public class SerializeAndDeserializeBinaryTree
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty())
        {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null) sb.append("null").append(",");
            else sb.append(left.val).append(",");

            if (right == null) sb.append("null").append(",");
            else sb.append(right.val).append(",");

            if (left != null)
            {
                queue.offer(left.left);
                queue.offer(left.right);
            }
            if (right != null)
            {
                queue.offer(right.left);
                queue.offer(right.right);
            }
        }

        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int level = 1;
        String[] array = data.split(",");
        if (array.length == 0 || array[0].equals("") || array[0].equals("null"))
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));

        int cur = 1;
        queue.offer(root);
        while (!queue.isEmpty() && cur < array.length)
        {
            int n = level * 2;
            for (int i = 0; i < n && cur < array.length; i = i + 2)
            {
                TreeNode node = queue.poll();
                node.left = process(array, cur, queue);
                cur++;
                node.right = process(array, cur, queue);
                cur++;
            }
        }
        return root;
    }

    private TreeNode process(String[] array, int cur, Queue<TreeNode> queue)
    {
        if ( cur >= array.length || array[cur].equals("null")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(array[cur]));
        queue.offer(node);
        return node;
    }

    public static void main(String[] args)
    {
        SerializeAndDeserializeBinaryTree app = new SerializeAndDeserializeBinaryTree();
        TreeNode node = app.deserialize("1,2,3,null,null,4,5,null,null,null,null");
        System.out.println(app.serialize(node));
        //ProjectUtil.printTree(node);
    }
}
