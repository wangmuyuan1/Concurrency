package com.mw.leetcode.p221top230;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

/**
 * Created by mwang on 01/05/2016.
 */
public class KthSmallestInBST230
{
    int count = 0;
    int val = -1;

    public int kthSmallest(TreeNode root, int k)
    {
        inOrder(root, k);
        return val;
    }

    public void inOrder(TreeNode root, int k)
    {
        if (root == null)
            return;
        inOrder(root.left, k);
        count++;
        if (count == k)
            val = root.val;
        inOrder(root.right, k);
    }
    public static void main(String[] args)
    {
        KthSmallestInBST230 app = new KthSmallestInBST230();
        TreeNode node = ProjectUtil.generateTree("4,2,5,1,3,6,7");
        System.out.println(app.kthSmallest(node, 8));
    }
}
