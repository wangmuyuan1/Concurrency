package com.mw.leetcode.p231to240;

import com.mw.leetcode.TreeNode;

/**
 * Created by mwang on 16/04/2016.
 */
public class LowestCommonAncestorofaBinaryTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
