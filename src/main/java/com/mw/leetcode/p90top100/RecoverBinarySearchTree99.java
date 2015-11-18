package com.mw.leetcode.p90top100;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

public class RecoverBinarySearchTree99
{
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root)
    {
        if (root == null)
            return;
        // secondly we need to swap the value.
        check(root);
        swap(first, second);
    }

    private void check(TreeNode root)
    {
        if (root == null)
            return;
        check(root.left); // if nothing found in left means left is valid. But first && second are both

        // when go left all the way. pre is not set. pre = null
        //                       root
        //                    null   null
        // and after this step. since pre is not set. before going to check right. pre = root;
        // so at the step of checking right. there should have no root < pre. so pre is only set when the search is going
        // to the right subtree of the root. so no root should less than pre.
        if (pre != null && root.val < pre.val) // this is tricky part. important.
        {
            if (first == null) // at this stage, should be found, the value of pre should less than the root. but we should go ahead.
                               // as the right tree may have a even smaller number than the root. so swap the first from the left tree.
                               // and second from the right tree will be sufficient.
                first = pre;
            second = root;
        }
        pre = root;
        check(root.right);
    }

    private void swap(TreeNode node1, TreeNode node2)
    {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public static void main(String[] args)
    {
        RecoverBinarySearchTree99 tree = new RecoverBinarySearchTree99();
        TreeNode root = ProjectUtil.generateTree("2,null,3,1");
        ProjectUtil.printTree(root);
        tree.recoverTree(root);
        ProjectUtil.printTree(root);
    }
}
