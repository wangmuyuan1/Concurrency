package com.mw.leetcode.p90top100;

import com.mw.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreeII95
{
    public static List<TreeNode> generateTrees(int n)
    {
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int min, int max)
    {
        List<TreeNode> result = new LinkedList<>();
        if (min > max)
        {
            result.add(null);
            return result;
        }

        for (int i = min; i <= max; i++)
        {
            List<TreeNode> lefts = generateTrees(min, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, max);
            for (TreeNode left : lefts)
            {
                for (TreeNode right : rights)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {

    }
}
