package com.mw.leetcode.p331to340;

import com.mw.leetcode.TreeNode;

/**
 * Created by mwang on 10/04/2016.
 */
public class HouseRobberIII337
{
    public int rob(TreeNode root)
    {
        int[] money = robber(root);
        return Math.max(money[0], money[1]);
    }

    private int[] robber(TreeNode root)
    {
        int[] result = {0, 0}; // The first is current level, the second is the child level.
        if (root == null)
            return result;
        int[] left = robber(root.left);
        int[] right = robber(root.right);

        int current = root.val + left[1] + right[1];
        int children =  Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // two levels can be skipped together
        result[0] = current;
        result[1] = children;
        return result;
    }

    public static void main(String[] args)
    {

    }
}
