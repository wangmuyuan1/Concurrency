package com.mw.leetcode.p90top100;

import com.mw.leetcode.TreeNode;

public class ValidateBinarySearchTree98
{
    public static boolean isValidBST(TreeNode root)
    {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode node, long min, long max)
    {
        if (node == null)
        {
            return true;
        }

        if (node.val > min && node.val < max &&
                isValid(node.left, min, node.val) && isValid(node.right, node.val, max))
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {

    }
}
