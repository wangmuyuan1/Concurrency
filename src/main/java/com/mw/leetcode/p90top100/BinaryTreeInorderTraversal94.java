package com.mw.leetcode.p90top100;

import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94
{
    public static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        inorderTraverse(result, root);
        return result;
    }

    private static void inorderTraverse(List<Integer> result, TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        inorderTraverse(result, root.left);
        result.add(root.val);
        inorderTraverse(result, root.right);
    }

    public static void main(String[] args)
    {

    }
}

