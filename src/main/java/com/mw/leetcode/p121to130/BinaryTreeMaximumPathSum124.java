package com.mw.leetcode.p121to130;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

public class BinaryTreeMaximumPathSum124
{
    private int maxBoth = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        getMaxSum(root);
        return maxBoth;
    }

    private int getMaxSum(TreeNode root)
    {
        if (root.left == null && root.right ==null)
        {
            this.maxBoth = Math.max(root.val, this.maxBoth);
            return root.val;
        }

        int leftMax = root.left == null ? 0 :getMaxSum(root.left);
        int rightMax = root.right == null ? 0 : getMaxSum(root.right);
        int localFullMax = root.val + (leftMax > 0 ? leftMax : 0);
        localFullMax += rightMax > 0 ? rightMax : 0;

        int localOneLeg = root.val + (leftMax > 0 || rightMax > 0 ? Math.max(leftMax, rightMax) : 0); //返回的时候只能返回一个leg
        this.maxBoth = Math.max(localFullMax, this.maxBoth); //但是计算的时候要计算两个leg
        return localOneLeg;
    }

    public static void main(String[] args)
    {
        TreeNode root = ProjectUtil.generateTree("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]");
        ProjectUtil.printTree(root);
        System.out.println(new BinaryTreeMaximumPathSum124().maxPathSum(root));
    }
}