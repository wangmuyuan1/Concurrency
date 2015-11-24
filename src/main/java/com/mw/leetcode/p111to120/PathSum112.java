package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

// TAG: [TREE] [RECURSIVE]
public class PathSum112
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        return hasPathSumRec(root, sum);
    }

    private boolean hasPathSumRec(TreeNode root, int sum)
    {
        // NOTE: There could be negative values in the tree. and the sum of root to its subtree could be zero.
        if (root == null)
            return false;

        if (root.val == sum && root.left == null && root.right == null)
            return true;
        else
        {
            boolean left = hasPathSum(root.left, sum - root.val);
            boolean right = hasPathSum(root.right, sum - root.val);
            return left || right;
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = ProjectUtil.generateTree("1,2");
        PathSum112 app = new PathSum112();
        ProjectUtil.printTree(root);
        System.out.println(app.hasPathSum(root, 1));
    }
}
