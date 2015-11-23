package com.mw.leetcode.p101to110;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

import java.util.*;

// TAG: [TREE] [LIST] [REVERSE]
public class BinaryTreeLevelOrderTraversalII107
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            // store child in to temp storage.
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> curResult = new ArrayList<>();
            for (TreeNode node : queue)
            {
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
                curResult.add(node.val);
            }
            result.add(curResult);
            queue.clear();
            queue.addAll(temp);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = ProjectUtil.generateTree("3,9,20,#,#,15,7");
        BinaryTreeLevelOrderTraversalII107 app = new BinaryTreeLevelOrderTraversalII107();
        for (List<Integer> list : app.levelOrderBottom(root))
        {
            for (Integer i : list)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
