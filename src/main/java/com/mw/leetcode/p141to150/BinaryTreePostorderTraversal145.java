package com.mw.leetcode.p141to150;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// TAGS: [TREE] [STACK] [COLLECTION_REVERSE]
public class BinaryTreePostorderTraversal145
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = ProjectUtil.generateTree("1,#,2,3");
        ProjectUtil.printTree(root);
        BinaryTreePostorderTraversal145 app = new BinaryTreePostorderTraversal145();
        app.postorderTraversal(root).forEach(System.out::print);
    }
}
