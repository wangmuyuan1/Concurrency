package com.mw.leetcode.p171to180;

import com.mw.leetcode.TreeNode;

import java.util.Stack;

public class BSTIterator
{
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root)
    {
        moveCurToNext(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next()
    {
        TreeNode tmpNode = stack.pop();
        moveCurToNext(tmpNode.right);
        return tmpNode.val;
    }

    private void moveCurToNext(TreeNode root)
    {
        TreeNode tmp = root;
        while (tmp != null)
        {
            stack.push(tmp);
            tmp = tmp.left;
        }// if tmp is null, then cur is null or tmp is most left or the root.
    }
}
