package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

public class MaximumDepthofBinaryTree104
{
    public static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
