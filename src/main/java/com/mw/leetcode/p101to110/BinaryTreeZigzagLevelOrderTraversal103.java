package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103
{
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        List<TreeNode> array = new ArrayList<>();
        array.add(root);

        List<Integer> val = new ArrayList<>();
        val.add(root.val);
        result.add(val);
        int i = 1;
        while (!array.isEmpty())
        {
            List<TreeNode> temp = new ArrayList<>();
            val = new ArrayList<>();
            for (TreeNode node : array)
            {
                if (node.left != null)
                {
                    temp.add(node.left);
                    val.add(node.left.val);
                }
                if (node.right != null)
                {
                    temp.add(node.right);
                    val.add(node.right.val);
                }
            }
            array.clear();
            array.addAll(temp);

            i++;
            if (i % 2 == 0)
                Collections.reverse(val);

            if (!val.isEmpty())
                result.add(val);
        }

        return result;
    }
}
