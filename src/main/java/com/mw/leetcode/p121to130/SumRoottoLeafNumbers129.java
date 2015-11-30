package com.mw.leetcode.p121to130;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

public class SumRoottoLeafNumbers129
{
    public int sumNumbers(TreeNode root)
    {
        int[] result = new int[1];
        if (root == null)
            return 0;
        sumLeaf(root, new StringBuilder(), result);
        return result[0];
    }

    private void sumLeaf(TreeNode root, StringBuilder sb, int[] result)
    {
        sb.append(root.val);
        if (root.left == null && root.right == null)
        {
            result[0] += Integer.parseInt(sb.toString());
        }

        if (root.left != null)
            sumLeaf(root.left, sb, result);
        if (root.right != null)
            sumLeaf(root.right, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args)
    {
        TreeNode node = ProjectUtil.generateTree("1,2,3");
        System.out.println(new SumRoottoLeafNumbers129().sumNumbers(node));
    }
}
