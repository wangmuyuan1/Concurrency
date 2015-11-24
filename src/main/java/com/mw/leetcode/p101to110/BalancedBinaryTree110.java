package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

// TAG: [TREE] [RECURSIVE]
public class BalancedBinaryTree110
{
    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
            return true;

        if (height(root) == -1)
            return false;
        return true;
    }

    public int height(TreeNode root)
    {
        if (root == null)
            return 0;

        // below is very important part.
        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(right, left) + 1;
    }
}
