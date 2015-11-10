package com.mw.leetcode.p101to110;

import com.mw.leetcode.TreeNode;

public class ConstructTreePreInOrder105
{
    // We use recursive to determine the value from pre and in order traverse.
    // the preorder traverse print root then left then right.
    // the inorder traverse print left then root then right.
    // we need to do pre order insert, insert root first and then insert the left sub-tree, and then right sub-tree.
    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length == 0)
            return null;

        return rec(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode rec(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart>inEnd) // IMPORTANT. preStart can equal but cannot be greater than preEnd.
            return null;

        TreeNode node = new TreeNode(preorder[preStart]); // prestart is definitely the root value.

        // actually build the left tree, we can get from the preStart but when we build the right tree it is tricky.
        // the immediate right tree is has to be determined by the inorder, as ab+, so we need to find out the index of current value
        // in the inorder traverse and then -1 to get the right tree.
        int i = inStart;
        for (; i <= inEnd; i++)
        {
            if (inorder[i] == preorder[preStart])
                break;
        }

        int len = i - inStart; // the length from inStart to the position i;

        // the preStart + len means the length of the left tree array start to start + len;
        // left sub tree size in preorder [preStart + 1, preStart + len].
        // left sub tree size in inorder [inStart, i - 1], because in inOrder, the left side is always less than the i.
        node.left = rec(preorder, inorder, preStart + 1, preStart + len, inStart, i - 1);

        // right sub tree size in preorder [preStart + len + 1, preEnd].
        // right sub tree size in inorder [i + 1, inEnd], because in inOrder, the right side is always greater than the i.
        node.right = rec(preorder, inorder, preStart + len + 1, preEnd, i + 1, inEnd);

        return node;
    }

    public static void main(String[] args)
    {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        buildTree(preorder, inorder);
    }
}
