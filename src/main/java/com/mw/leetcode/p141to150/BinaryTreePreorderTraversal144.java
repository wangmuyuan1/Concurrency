package com.mw.leetcode.p141to150;

import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        // 用栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }

        return result;
    }
}
