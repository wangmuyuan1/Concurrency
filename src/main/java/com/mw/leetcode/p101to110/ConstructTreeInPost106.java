package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

public class ConstructTreeInPost106
{
    // We use recursive to determine the value from in order and post order traverse.
    // the postorder traverse print left then right then root.
    // the inorder traverse print left then root then right.
    // we need to do pre order insert, insert root first and then insert the left sub-tree, and then right sub-tree.
    public static TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if (inorder.length == 0)
            return null;

        return rec(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode rec(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)
    {
        if (postStart > postEnd || inStart>inEnd) // IMPORTANT. preStart can equal but cannot be greater than preEnd.
            return null;

        TreeNode node = new TreeNode(postorder[postEnd]); // postEnd is definitely the root value.

        // actually build the left tree, we can get from the preStart but when we build the right tree it is tricky.
        // the immediate right tree is has to be determined by the inorder, as a+b, so we need to find out the index of current value
        // in the inorder traverse and then -1 to get the right tree.
        int i = inStart;
        for (; i <= inEnd; i++)
        {
            if (inorder[i] == postorder[postEnd])
                break;
        }

        int len = i - inStart; // the length from inStart to the position i is the left tree.

        // the postStart + len means the length of the left tree array start to start + len;
        // left sub tree size in postorder [postStart, postStart + len].
        // left sub tree size in inorder [inStart, i - 1], because in inOrder, the left side is always less than the i.
        node.left = rec(inorder, postorder, inStart, i - 1, postStart, postStart + len - 1);

        // right sub tree size in postorder [postStart + len + 1, postEnd].
        // right sub tree size in inorder [i + 1, inEnd], because in inOrder, the right side is always greater than the i.
        node.right = rec(inorder, postorder, i + 1, inEnd, postStart + len, postEnd - 1);

        return node;
    }
}
