package com.mw.leetcode.p221top230;

import com.mw.leetcode.TreeNode;

/**
 * Created by mwang on 03/05/2016.
 */
public class InvertBinaryTree226
{
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
