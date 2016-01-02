package com.mw.leetcode.p221top230;

import com.mw.leetcode.TreeNode;

public class CountCompleteTreeNodes222
{
    public int countNodes(TreeNode root)
    {
        int h = height(root);
        return height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : // left is full.
                (1 << h - 1) + countNodes(root.left); // right is full with height h - 1
    }

    private int height(TreeNode root)
    {
        return root == null ? 0 : 1 + height(root.left);
    }
}
