package com.mw.leetcode.p90top100;

import com.mw.leetcode.TreeNode;

public class SameTree100
{
    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
