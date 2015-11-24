package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

// TAG: [TREE] [RECURSIVE]
public class FlattenBinaryTreetoLinkedList114
{
    public void flatten(TreeNode root)
    {
        flat(root);
    }

    private TreeNode flat(TreeNode node)
    {
        if (node == null)
            return null;

        TreeNode left = flat(node.left);
        TreeNode right = flat(node.right);

        if (left != null)
        {
            node.right = left;
            TreeNode leftTemp = left;
            while (leftTemp.right != null)
                leftTemp = leftTemp.right;
            leftTemp.right = right;
        }
        node.left = null;
        return node;
    }

    public static void main(String[] args)
    {
        TreeNode node = ProjectUtil.generateTree("1,2,5,3,4,#,6");
        ProjectUtil.printTree(node);
        new FlattenBinaryTreetoLinkedList114().flat(node);
        ProjectUtil.printTree(node);
    }
}
