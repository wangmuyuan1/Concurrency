package com.mw.leetcode.p111to120;

import com.mw.leetcode.TreeNode;

public class MinimumDepthofBinaryTree111
{
    public int minDepth(TreeNode root)
    {
        return minDepthRec(root);
    }

    private int minDepthRec(TreeNode root)
    {
        if (root == null)
            return 0;
        int left = minDepthRec(root.left);
        int right = minDepthRec(root.right);

        if (left == 0) // Important: this is to check if it is leaf node.
            return right + 1;
        else if (right == 0)
            return left + 1;
        else
            return Math.min(left, right) + 1;
    }

    public static void main(String[] args)
    {

    }
}
