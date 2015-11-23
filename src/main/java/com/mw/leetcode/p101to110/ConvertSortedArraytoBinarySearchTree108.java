package com.mw.leetcode.p101to110;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

// TAG: [TREE] [RECURSIVE]
public class ConvertSortedArraytoBinarySearchTree108
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end)
    {
        if (start == end)
            return new TreeNode(nums[start]);

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (start <= mid - 1)
            node.left = sortedArrayToBST(nums, start, mid - 1);
        if (mid + 1 <= end)
            node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }

    public static void main(String[] args)
    {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ConvertSortedArraytoBinarySearchTree108 app = new ConvertSortedArraytoBinarySearchTree108();
        ProjectUtil.printTree(app.sortedArrayToBST(nums));
    }
}
