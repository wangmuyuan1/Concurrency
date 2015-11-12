package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

public class SymmetricTree101
{
    public static boolean isSymmetric(TreeNode root)
    {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
            return true;
        else if ((left == null && right != null) || (left != null && right == null) || left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
